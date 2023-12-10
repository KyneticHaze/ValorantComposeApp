package com.example.valorantcomposeapp.presentation.all_agents

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.domain.model.Agent
import com.example.valorantcomposeapp.domain.use_case.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class GetAgentsViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase
) : ViewModel() {

    private var allAgents = listOf<Agent>() // agent object list
    private val _state = mutableStateOf(AgentsState())
    val state : State<AgentsState> = _state

    private var _searchQuery = mutableStateOf("")
    val searchQuery : State<String> = _searchQuery

    init {
        loadAgents()
    }
    private fun loadAgents() {
        getAgentsUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
                is Resource.Success -> {
                    result.data?.let {
                        _state.value = _state.value.copy(agents = it)
                    }
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(error = result.errorMessage ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun searchAgents(query: String) {
        _searchQuery.value = query
        _state.value = _state.value.copy(isLoading = true)

        val foundAgents =
            allAgents.filter {
                it.displayName.contains(query, true) or
                        it.description.contains(query, true)
            }

        if (foundAgents.isEmpty()) {
            _state.value = _state.value.copy(error = "No agents found")
        } else {
            _state.value = _state.value.copy(agents = foundAgents)
        }
    }

    fun clearSearchQuery() {
        _state.value = AgentsState(agents = allAgents)
        _searchQuery.value = ""
    }
}