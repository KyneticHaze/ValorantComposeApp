package com.example.valorantcomposeapp.presentation.tiers

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.domain.use_case.tiers.AllTiersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class AllTiersViewModel @Inject constructor(
    private val allTiersUseCase: AllTiersUseCase
) : ViewModel() {

    private val _tiersState = mutableStateOf(TierState())
    val tierState: State<TierState> = _tiersState

    init {
        loadAllTiers()
    }

    private fun loadAllTiers() {
        allTiersUseCase().onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _tiersState.value = _tiersState.value.copy(isLoading = true)
                }

                is Resource.Success -> {
                    _tiersState.value = _tiersState.value.copy(tiers = resource.data ?: emptyList())
                }

                is Resource.Error -> {
                    _tiersState.value =
                        _tiersState.value.copy(error = resource.errorMessage ?: "Not Found Tiers!")
                }
            }
        }.launchIn(viewModelScope)
    }
}