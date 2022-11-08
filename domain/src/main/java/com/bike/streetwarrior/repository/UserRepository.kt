package com.bike.streetwarrior.repository

import com.bike.streetwarrior.model.Either
import com.bike.streetwarrior.model.Failure
import com.bike.streetwarrior.model.User


interface UserRepository {
    fun getUserInfo(userId: String): Either<Failure, User>
}