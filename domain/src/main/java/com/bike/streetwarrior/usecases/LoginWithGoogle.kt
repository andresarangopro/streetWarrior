package com.bike.streetwarrior.usecases


import com.bike.streetwarrior.repository.AuthRepository
import javax.inject.Inject


class LoginWithGoogleUseCase
@Inject constructor(val authRepository: AuthRepository) {
    suspend fun run() = authRepository.signUpWithGoogle()
}