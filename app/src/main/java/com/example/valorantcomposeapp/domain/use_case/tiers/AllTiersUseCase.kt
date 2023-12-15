package com.example.valorantcomposeapp.domain.use_case.tiers

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.data.dto.tiers.TierDTO
import com.example.valorantcomposeapp.data.dto.tiers.toTier
import com.example.valorantcomposeapp.domain.model.Tier
import com.example.valorantcomposeapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class AllTiersUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {
    operator fun invoke() : Flow<Resource<List<Tier>>> = flow {
        try {
            valorantRepository.getAllTiers().data?.last()?.tiers?.let { tierDtos ->
                val tiers = arrayListOf<TierDTO>()
                tierDtos.forEach { tierDTO ->
                    if (tierDTO.rankTriangleUpIcon != null) {
                        tiers.add(tierDTO)
                    }
                }
                emit(Resource.Success(tiers.map { it.toTier() }))
            }
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected internet connection occured!"))
        } catch (e : IOException) {
            emit(Resource.Error(e.localizedMessage?: "Not found IO!"))
        }
    }
}