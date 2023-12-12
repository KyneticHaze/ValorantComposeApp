package com.example.valorantcomposeapp.domain.use_case.maps

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.data.dto.maps.toMap
import com.example.valorantcomposeapp.domain.model.Map
import com.example.valorantcomposeapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetMapsUseCase @Inject constructor(
    private val repo : ValorantRepository
) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke() : Flow<Resource<List<Map>>> = flow {
        try {
            repo.getAllMaps().data?.map { it.toMap() }?.let {
                emit(Resource.Success(it))
            }
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        } catch (e : IOException) {
            emit(Resource.Error(e.localizedMessage?: ""))
        }
    }
}