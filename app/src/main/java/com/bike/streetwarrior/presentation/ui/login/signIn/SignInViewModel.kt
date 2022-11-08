package com.bike.streetwarrior.presentation.ui.login.signIn



import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.bike.streetwarrior.custom.component.ParamsMailAndPassword
import com.bike.streetwarrior.model.Response.Success
import com.bike.streetwarrior.model.Response
import com.bike.streetwarrior.model.User
import com.bike.streetwarrior.presentation.BaseViewModel
import com.bike.streetwarrior.presentation.RouteNavigator
import com.bike.streetwarrior.presentation.States
import com.bike.streetwarrior.repository.AuthRepository
import com.bike.streetwarrior.repository.SignInWithGoogleResponse
import com.bike.streetwarrior.usecases.GetUserInfoUseCase
import com.bike.streetwarrior.usecases.LoginWithEmailAndPasswordUseCase
import com.bike.streetwarrior.usecases.LoginWithGoogleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignInViewModel@Inject constructor(
    private val routeNavigator: RouteNavigator,
    private val repo: AuthRepository,
    private val loginWithGoogleUseCase: LoginWithGoogleUseCase,
    private val loginWithEmailAndPasswordUseCase: LoginWithEmailAndPasswordUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val firebaseAuth: FirebaseAuth

    ): BaseViewModel<EventsSignInViewModel, StatesSignInViewModel>() , RouteNavigator by routeNavigator {

    val isUserAuthenticated get() = repo.isUserAuthenticatedInFirebase
    val displayName get() = repo.displayName
    val photoUrl get() = repo.photoUrl
    private lateinit var _user: FirebaseUser

    var oneTapSignInResponse by mutableStateOf<Response<BeginSignInResult>>(Success(null))
        private set

    var signInWithGoogleResponse by mutableStateOf<SignInWithGoogleResponse>(Success(false))
        private set

    private val _states: MutableLiveData<States<StatesSignInViewModel>> = MutableLiveData()
    val states: LiveData<States<StatesSignInViewModel>> get() = _states


    fun loginWithGoogle()= viewModelScope.launch {
        loginWithGoogleUseCase.run().collect{ response ->
            when(response){
                is Response.Loading ->{}
                is Response.Success ->{
                    response.data?.let {_states.value = States( StatesSignInViewModel.OnIntentGoogleSignIn(it) ) }
                }
                is Response.Error -> {}
            }
        }
    }


    fun loginWithEmailAndPassword(params: ParamsMailAndPassword)=viewModelScope.launch {
        try {
            Log.d("logmailpass","${params.onMailChange} -- ${params.onPassChange}")
            loginWithEmailAndPasswordUseCase.run(params.onMailChange.toString(), params.onPassChange.toString()).collect{ response ->
                when(response){
                    is Response.Loading ->{
                        _states.value = States(StatesSignInViewModel.IsLoading)
                    }
                    is Response.Success ->{
                        _states.value = States(StatesSignInViewModel.ToMainActivity)
                    }
                    is Response.Error -> {}
                }
            }
        }catch (e: Exception){

        }
    }

    fun finishLogin(task: Task<GoogleSignInAccount>){
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
            account?.idToken?.let{token ->
                val auth = FirebaseAuth.getInstance()
                val credential = GoogleAuthProvider.getCredential(token, null)
                auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        getInfoUser()
                    }
            }
        }catch (e: ApiException){
            Log.d("dontworks","yeap dont Works ${e.message}")
        }
    }

    fun getInfoUser(){
        firebaseAuth.uid?.let { GetUserInfoUseCase.Params(it) }
            ?.let { getUserInfoUseCase.invoke(it){
                it.fold(
                    {        Log.d("userInfoERR", "${it}")},
                    ::handleUserInfo
                )
            } }
    }

    private fun handleUserInfo(userInfo: User) {
        Log.d("userInfo", "$userInfo")
        // _states.value = States(StatesSignInViewModel.ToMainActivity)
    }

    override fun manageEvent(event: EventsSignInViewModel) {
        when(event){
            is EventsSignInViewModel.loginWithEmailAndPass ->{
                loginWithEmailAndPassword(event.params)
            }
            else->{}
        }
    }
}
