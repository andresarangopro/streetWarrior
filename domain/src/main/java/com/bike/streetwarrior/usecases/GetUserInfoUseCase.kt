package com.bike.streetwarrior.usecases

import com.bike.streetwarrior.model.UseCase
import com.bike.streetwarrior.model.User
import com.bike.streetwarrior.repository.UserRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(private val userRepository: UserRepository):
    UseCase<User, GetUserInfoUseCase.Params>() {

    override suspend fun run(params: Params) = userRepository.getUserInfo(params.id)

    data class Params(val id: String)
}