package com.example.valorantcomposeapp.presentation.weapons.all_weapons

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.domain.use_case.weapons.GetAllWeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class WeaponsViewModel @Inject constructor(
    private val getAllWeaponsUseCase : GetAllWeaponsUseCase
) : ViewModel() {

    private val _weaponState = mutableStateOf(WeaponsState())
    val weaponState : State<WeaponsState> = _weaponState

    init {
        loadWeapons()
    }

    private fun loadWeapons() {
        getAllWeaponsUseCase().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _weaponState.value = _weaponState.value.copy(
                        weapons = resource.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _weaponState.value = _weaponState.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Error -> {
                    _weaponState.value = _weaponState.value.copy(
                        isLoading = false,
                        error = "Not found weapons!"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}