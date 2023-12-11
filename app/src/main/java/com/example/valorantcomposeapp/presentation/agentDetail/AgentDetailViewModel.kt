package com.example.valorantcomposeapp.presentation.agentDetail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantcomposeapp.common.Params
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.domain.use_case.GetAgentDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val getAgentDetailUseCase: GetAgentDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _agentState = mutableStateOf(AgentDetailState())
    val agentState : State<AgentDetailState> = _agentState

    init {
        savedStateHandle.get<String>(Params.PARAM_AGENT_ID)?.let { agentId ->
            getAgentDetail(agentId)
        }
    }

    private fun getAgentDetail(uuid : String) {
        getAgentDetailUseCase.invoke(uuid).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _agentState.value = _agentState.value.copy(isLoading = true)
                }
                is Resource.Success -> {
                    _agentState.value = _agentState.value.copy(agent = result.data)
                }
                is Resource.Error -> {
                    _agentState.value = _agentState.value.copy(error = result.errorMessage?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
}