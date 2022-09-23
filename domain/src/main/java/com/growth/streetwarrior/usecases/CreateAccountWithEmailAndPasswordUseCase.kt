package com.growth.streetwarrior.usecases


import com.growth.streetwarrior.repository.AuthRepository
import javax.inject.Inject


class CreateAccountWithEmailAndPasswordUseCase
@Inject constructor(val authRepository: AuthRepository) {
    suspend fun run(email: String, password: String) = authRepository.createAccountWithEmailAndPassword(email, password)
}