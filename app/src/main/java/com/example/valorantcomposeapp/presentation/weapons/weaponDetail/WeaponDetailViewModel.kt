package com.example.valorantcomposeapp.presentation.weapons.weaponDetail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantcomposeapp.common.Params
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.domain.use_case.weapons.GetWeaponByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class WeaponDetailViewModel @Inject constructor(
    private val getWeaponByIdUseCase: GetWeaponByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _weaponState = mutableStateOf(WeaponDetailState())
    val weaponState : State<WeaponDetailState> = _weaponState

    init {
        savedStateHandle.get<String>(Params.PARAM_WEAPON_ID)?.let {
            loadWeaponDetail(it)
        }
    }

    private fun loadWeaponDetail(weaponUuid : String) {
        getWeaponByIdUseCase(weaponUuid).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                 _weaponState.value = _weaponState.value.copy(
                     isLoading = true
                 )
                }
                is Resource.Success -> {
                    _weaponState.value = _weaponState.value.copy(
                        isLoading = false,
                        weapon = result.data
                    )
                }
                is Resource.Error -> {
                    _weaponState.value = _weaponState.value.copy(
                        isLoading = false,
                        error = result.errorMessage ?: "Not found Weapon Detail!"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}