package com.bike.streetwarrior.repository

import android.util.Log
import com.bike.streetwarrior.entities.UserEntity
import com.bike.streetwarrior.model.Either
import com.bike.streetwarrior.model.Failure
import com.bike.streetwarrior.model.User
import com.bike.streetwarrior.repository.extensions.request
import com.bike.streetwarrior.repository.platform.NetworkHandler
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RemoteDataSource
@Inject constructor(retrofit: Retrofit) : UsersApi{
    private val userApi by lazy { retrofit.create(UsersApi::class.java) }

    override fun userDetails(authHeader: String, userId: String): Call<UserEntity> =
        userApi.userDetails(authHeader, userId)

}

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val networkHandler: NetworkHandler,
    ): UserRepository {
    override fun getUserInfo(userId: String): Either<Failure, User> {
        val request: Either<Failure, User> = when (networkHandler.isNetworkAvailable()) {
            true -> {
                request(
                    remoteDataSource.userDetails("token", userId),
                    { it.toUserDomain() },
                    UserEntity.empty
                )
            }
            false -> {
                Either.Left(Failure.NetworkConnection)
            }
        }
        request.fold(
            fnL = {
                when(it){
                    is Failure.NetworkConnection->{
                        Log.d("userInfoERR  ","NetworkConnection")
                    }
                    is Failure.ServerError->{
                        Log.d("userInfoERR  ","ServerError")
                    }
                    is Failure.Empty -> {
                        Log.d("userInfoERR  ","${it.message}")
                    }
                    else ->{
                        Log.d("userInfoERR  ","ELSE")
                    }
                }
          },
            fnR = {//TODO() when is success you are able to save data from there
                 }
        )
        return  request
    }
}