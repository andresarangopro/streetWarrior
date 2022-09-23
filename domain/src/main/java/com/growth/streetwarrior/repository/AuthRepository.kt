package com.growth.streetwarrior.repository

import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.firebase.auth.AuthCredential
import com.growth.streetwarrior.model.Response
import kotlinx.coroutines.flow.Flow


typealias OneTapSignInResponse = Response<BeginSignInResult>
typealias SignInWithGoogleResponse = Response<Boolean>

interface AuthRepository {

    val isUserAuthenticatedInFirebase: Boolean
    val displayName: String
    val photoUrl: String

    fun oneTapSignInWithGoogle(): Flow<Response<BeginSignInResult>>

    suspend fun oneTapSignUpWithGoogle(): Flow<Response<BeginSignInResult>>

    suspend fun firebaseSignInWithGoogle(googleCredential: AuthCredential): Flow<Response<Boolean>>

    suspend fun createUserInFirestore(): Flow<Response<Boolean>>

    suspend fun signOut(): Flow<Response<Boolean>>

    suspend fun revokeAccess(): Flow<Response<Boolean>>

    fun getFirebaseAuthState(): Flow<Boolean>
}