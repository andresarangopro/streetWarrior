package com.bike.streetwarrior.repository


import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.firestore.FieldValue.serverTimestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.bike.streetwarrior.model.Response
import com.bike.streetwarrior.model.Response.*
import com.bike.streetwarrior.repository.Constants.CREATED_AT
import com.bike.streetwarrior.repository.Constants.DISPLAY_NAME
import com.bike.streetwarrior.repository.Constants.EMAIL
import com.bike.streetwarrior.repository.Constants.NO_DISPLAY_NAME
import com.bike.streetwarrior.repository.Constants.PHOTO_URL
import com.bike.streetwarrior.repository.Constants.SIGN_IN_REQUEST
import com.bike.streetwarrior.repository.Constants.SIGN_UP_REQUEST
import com.bike.streetwarrior.repository.Constants.USERS_REF
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl  @Inject constructor(
    private val auth: FirebaseAuth,
    private var oneTapClient: SignInClient,
    @Named(SIGN_IN_REQUEST)
    private var signInRequest: BeginSignInRequest,
    @Named(SIGN_UP_REQUEST)
    private var signUpRequest: BeginSignInRequest,
    private var signInClient: GoogleSignInClient,
    private val db: FirebaseFirestore
) : AuthRepository {
    override val isUserAuthenticatedInFirebase = auth.currentUser != null
    override val displayName = auth.currentUser?.displayName ?: NO_DISPLAY_NAME
    override val photoUrl = auth.currentUser?.photoUrl.toString()

    override fun oneTapSignInWithGoogle() = flow {
        try {
            emit(Loading)
            val result = oneTapClient.beginSignIn(signInRequest).await()
            emit(Success(result))
        } catch (e: Exception) {
            emit(Error(e))
        }
    }

    override suspend fun oneTapSignUpWithGoogle() = flow {
        try {
            emit(Loading)
            val result = oneTapClient.beginSignIn(signUpRequest).await()
            emit(Success(result))
        } catch (e: Exception) {
            emit(Error(e))
        }
    }

    override suspend fun signUpWithGoogle() = flow {
        try {
            emit(Loading)
            val result = signInClient.signInIntent
            emit(Success(result))
        } catch (e: Exception) {
            emit(Error(e))
        }
    }

    override suspend fun firebaseSignInWithGoogle(googleCredential: AuthCredential): Flow<Response<Boolean>> = flow {
        try {
            emit(Loading)
            val authResult = auth.signInWithCredential(googleCredential).await()
            val isNewUser = authResult.additionalUserInfo?.isNewUser
            emit(Success(isNewUser))
        } catch (e: Exception) {
            emit(Error(e))
        }
    }

    override suspend fun createUserInFirestore(): Flow<Response<Boolean>> = flow {
        try {
            emit(Loading)
            auth.currentUser?.apply {
                db.collection(USERS_REF).document(uid).set(mapOf(
                    DISPLAY_NAME to displayName,
                    EMAIL to email,
                    PHOTO_URL to photoUrl?.toString(),
                    CREATED_AT to serverTimestamp()
                )).await()
                emit(Success(true))
            }
        } catch (e: Exception) {
            emit(Error(e))
        }
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Response<Task<AuthResult>>> = flow{
        try{
            var _task: Task<AuthResult>?= null
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task->
                _task = task
            }.await()

            if(_task?.isSuccessful == true){
                emit(Success(_task))
            }else{
                emit(Error(_task?.exception))
            }
        }catch (e: Exception){
            emit(Error(e))
        }

    }

    override suspend fun createAccountWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<Response<Task<AuthResult>>> = flow {
        try{
            var _task: Task<AuthResult>?= null
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task->
                _task = task
            }.await()

            if(_task?.isSuccessful == true){
                emit(Success(_task))
            }else{
                emit(Error(_task?.exception))
            }
        }catch (e: Exception){
            emit(Error(e))
        }
    }

    override fun getFirebaseAuthState() = callbackFlow  {
        val authStateListener = AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }



    override suspend fun signOut(): Flow<Response<Boolean>> = flow {
        try {
            emit(Loading)
            auth.signOut()
            oneTapClient.signOut().await()
            emit(Success(true))
        } catch (e: Exception) {
            emit(Error(e))
        }
    }

    override suspend fun revokeAccess(): Flow<Response<Boolean>> = flow {
        try {
            emit(Loading)
            auth.currentUser?.apply {
                db.collection(USERS_REF).document(uid).delete().await()
                delete().await()
                signInClient.revokeAccess().await()
                oneTapClient.signOut().await()
            }
            emit(Success(true))
        } catch (e: Exception) {
            emit(Error(e))
        }
    }

}