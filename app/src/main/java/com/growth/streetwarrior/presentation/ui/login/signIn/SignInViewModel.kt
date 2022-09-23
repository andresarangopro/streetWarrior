package com.growth.streetwarrior.presentation.ui.login.signIn

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.growth.streetwarrior.model.Response.Success
import com.growth.streetwarrior.model.Response
import com.growth.streetwarrior.presentation.RouteNavigator
import com.growth.streetwarrior.presentation.ui.groupmotorbikershandle.MainActivity
import com.growth.streetwarrior.presentation.ui.login.ActivityActions
import com.growth.streetwarrior.repository.AuthRepository
import com.growth.streetwarrior.repository.SignInWithGoogleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignInViewModel@Inject constructor(
    private val routeNavigator: RouteNavigator,
    private val repo: AuthRepository,
    val oneTapClient: SignInClient,
    val clientFirebase: GoogleSignInClient,
    val activityActions: ActivityActions
): ViewModel(), RouteNavigator by routeNavigator {


    val isUserAuthenticated get() = repo.isUserAuthenticatedInFirebase
    val displayName get() = repo.displayName
    val photoUrl get() = repo.photoUrl

    private lateinit var _user: FirebaseUser

    var oneTapSignInResponse by mutableStateOf<Response<BeginSignInResult>>(Success(null))
        private set
    var oneTapSignUpResponse by mutableStateOf<Response<BeginSignInResult>>(Success(null))
        private set
    var signInResponse by mutableStateOf<Response<Boolean>>(Success(null))
        private set
    var createUserResponse by mutableStateOf<Response<Boolean>>(Success(null))
        private set
    var signOutResponse by mutableStateOf<Response<Boolean>>(Success(false))
        private set
    var revokeAccessResponse by mutableStateOf<Response<Boolean>>(Success(false))
        private set

    var signInWithGoogleResponse by mutableStateOf<SignInWithGoogleResponse>(Success(false))
        private set

    var _googleClient = MutableLiveData<GoogleSignInClient>()
    val googleClient : LiveData<GoogleSignInClient> get() = _googleClient


    fun getAuthState() = viewModelScope.launch(Dispatchers.IO){
        repo.getFirebaseAuthState().collect{response ->

        }
    }

    fun oneTapSignIn() = viewModelScope.launch {
        repo.oneTapSignInWithGoogle().collect { response ->
            oneTapSignInResponse = response
        }
    }


    private fun ComponentActivity.singInLauncher() = this.registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ){
            res -> singInResult(res)
    }

    private fun singInResult(result: FirebaseAuthUIAuthenticationResult){
        val response = result.idpResponse
        if(result.resultCode == RESULT_OK){
            var user = FirebaseAuth.getInstance().currentUser
        }
    }

    fun singIn( activity: ComponentActivity){
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
        )
        val signinIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()

        activity.singInLauncher().launch(signinIntent)
    }

    fun finishLogin(task: Task<GoogleSignInAccount>, current: Context){
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
            Log.d("works","yeapWorks")
            account?.idToken?.let{token ->
                val auth = FirebaseAuth.getInstance()
                val credential = GoogleAuthProvider.getCredential(token, null)

                auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                       current.startActivity(Intent(current, MainActivity::class.java))
                    }
            }
        }catch (e: ApiException){
            Log.d("dontworks","yeap dont Works ${e.message}")
        }
    }

    fun oneTapSignUp() = viewModelScope.launch {
        repo.oneTapSignUpWithGoogle().collect { response ->
            oneTapSignUpResponse = response
        }
    }

    fun signInWithGoogle(googleCredential: AuthCredential) = viewModelScope.launch {
        repo.firebaseSignInWithGoogle(googleCredential).collect { response ->
            signInResponse = response
        }
    }

    fun createUser() = viewModelScope.launch {
        repo.createUserInFirestore().collect { response ->
            createUserResponse = response
        }
    }

    fun signOut() = viewModelScope.launch {
        repo.signOut().collect { response ->
            signOutResponse = response
        }
    }

    fun revokeAccess() = viewModelScope.launch {
        repo.revokeAccess().collect { response ->
            revokeAccessResponse = response
        }
    }
}
