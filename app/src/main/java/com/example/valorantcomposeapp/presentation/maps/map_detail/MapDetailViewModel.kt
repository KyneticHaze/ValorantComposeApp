package com.example.valorantcomposeapp.presentation.maps.map_detail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantcomposeapp.common.Params
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.domain.use_case.maps.GetMapUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class MapDetailViewModel @Inject constructor(
    private val getMapUseCase : GetMapUseCase,
    stateHandle: SavedStateHandle
) : ViewModel() {

    private val _mapDetailState = mutableStateOf(MapDetailState())
    val mapDetailState : State<MapDetailState> = _mapDetailState

    init {
        stateHandle.get<String>(Params.PARAM_MAP_ID)?.let { mapId ->
            loadMap(mapId)
        }
    }

    private fun loadMap(uuid : String) {
        getMapUseCase(uuid).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _mapDetailState.value = _mapDetailState.value.copy(isLoading = true)
                }
                is Resource.Success -> {
                    result.data?.let { 
                        _mapDetailState.value = _mapDetailState.value.copy(mapDetail = it)
                    }
                }
                is Resource.Error -> {
                    _mapDetailState.value = _mapDetailState.value.copy(error = result.errorMessage ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
}