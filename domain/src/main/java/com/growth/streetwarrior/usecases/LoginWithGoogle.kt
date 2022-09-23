package com.growth.streetwarrior.usecases


import com.growth.streetwarrior.repository.AuthRepository
import javax.inject.Inject


class LoginWithGoogleUseCase
@Inject constructor(val authRepository: AuthRepository) {
    suspend fun run() = authRepository.signUpWithGoogle()
}