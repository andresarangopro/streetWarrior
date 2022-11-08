package com.bike.streetwarrior.repository.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.bike.streetwarrior.model.Either
import com.bike.streetwarrior.model.Failure
import retrofit2.Call

val Context.connectivityManager: ConnectivityManager
    get() =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

fun <T, R> request(
    call: Call<T>,
    transform: (T) -> R,
    default: T
): Either<Failure, R> {
    return try {
        val response = call.execute()
        when (response.isSuccessful) {
            true -> Either.Right(transform((((response.body() ?: default)))))
            false -> Either.Left(Failure.ServerError)
        }
    } catch (exception: Throwable) {
        Either.Left(Failure.Empty(exception.message.toString()))
    }
}


