package com.example.valorantcomposeapp.presentation.maps.all_maps

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.domain.use_case.maps.GetMapsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class MapsViewModel @Inject constructor(
    private val getMapsUseCase: GetMapsUseCase
) : ViewModel() {

    private val _mapsState = mutableStateOf(MapsState())
    val mapsState : State<MapsState> = _mapsState

    init {
        getMaps()
    }

    private fun getMaps() {
        getMapsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    result.data?.let {
                        _mapsState.value = _mapsState.value.copy(maps = it)
                    }
                }
                is Resource.Loading -> {
                    _mapsState.value = _mapsState.value.copy(isLoading = true)
                }
                is Resource.Error -> {
                    _mapsState.value = _mapsState.value.copy(error = result.errorMessage ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
}