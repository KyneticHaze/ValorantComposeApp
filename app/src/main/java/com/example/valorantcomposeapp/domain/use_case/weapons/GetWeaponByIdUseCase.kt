package com.example.valorantcomposeapp.domain.use_case.weapons

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.data.dto.weapons.Skin
import com.example.valorantcomposeapp.data.dto.weapons.WeaponDTO
import com.example.valorantcomposeapp.data.dto.weapons.toWeapon
import com.example.valorantcomposeapp.domain.model.weapon.Weapon
import com.example.valorantcomposeapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class GetWeaponByIdUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {

    operator fun invoke(weaponUuid : String) : Flow<Resource<Weapon>> = flow {
        try {
            valorantRepository.getWeaponByUuid(weaponUuid).data?.toWeapon()?.let { weapon ->
                val visibleSkin = arrayListOf<Skin>()
                weapon.skins?.forEach {
                    if (it.displayIcon.isNullOrEmpty().not() && it.displayName.orEmpty().contains("Standard").not()) {
                        visibleSkin.add(it)
                    }
                }
                weapon.skins = visibleSkin
                emit(Resource.Success(weapon))
            }
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected internet connection occured!"))
        } catch (e : IOException) {
            emit(Resource.Error(e.localizedMessage?: "Not found IO!"))
        }
    }
}