package com.bike.streetwarrior.repository

import com.bike.streetwarrior.entities.UserEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersApi{
    companion object {
        private const val PARAM_USER_ID = "id"
        private const val USER_DETAILS = "users"
    }

    @GET(USER_DETAILS)
    fun userDetails(@Header("Authorization")  authHeader:String, @Query(PARAM_USER_ID) userId: String): Call<UserEntity>
}