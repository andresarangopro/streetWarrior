package com.growth.streetwarrior.usecases


import com.growth.streetwarrior.repository.AuthRepository
import javax.inject.Inject


class LoginWithEmailAndPasswordUseCase
@Inject constructor(val authRepository: AuthRepository) {
    suspend fun run(email: String, password: String) = authRepository.signInWithEmailAndPassword(email, password)
}