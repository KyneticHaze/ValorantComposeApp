package com.example.valorantcomposeapp.domain.use_case.agents

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.data.dto.agents.toAgent
import com.example.valorantcomposeapp.domain.model.Agent
import com.example.valorantcomposeapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetAgentsUseCase @Inject constructor(
    private val repo: ValorantRepository
) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(): Flow<Resource<List<Agent>>> = flow {
        try {
            repo.getAgents().data?.map { it.toAgent() }?.let {
                emit(Resource.Success(it))
            }
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e : IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}