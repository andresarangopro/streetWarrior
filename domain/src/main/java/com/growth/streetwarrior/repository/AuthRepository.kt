package com.growth.streetwarrior.repository

import android.content.Intent
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.growth.streetwarrior.model.Either
import com.growth.streetwarrior.model.Failure
import com.growth.streetwarrior.model.Response
import kotlinx.coroutines.flow.Flow



typealias SignInWithGoogleResponse = Response<Boolean>

interface AuthRepository {

    val isUserAuthenticatedInFirebase: Boolean
    val displayName: String
    val photoUrl: String

    fun oneTapSignInWithGoogle(): Flow<Response<BeginSignInResult>>

    suspend fun oneTapSignUpWithGoogle(): Flow<Response<BeginSignInResult>>

    suspend fun firebaseSignInWithGoogle(googleCredential: AuthCredential): Flow<Response<Boolean>>

    suspend fun signUpWithGoogle(): Flow<Response<Intent>>

    suspend fun createUserInFirestore(): Flow<Response<Boolean>>

    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Response<Task<AuthResult>>>

    suspend fun createAccountWithEmailAndPassword(email: String, password: String): Flow<Response<Task<AuthResult>>>

    suspend fun signOut(): Flow<Response<Boolean>>

    suspend fun revokeAccess(): Flow<Response<Boolean>>

    fun getFirebaseAuthState(): Flow<Boolean>
}