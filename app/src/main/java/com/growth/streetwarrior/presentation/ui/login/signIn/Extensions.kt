package com.growth.streetwarrior.presentation.ui.login.signIn

import android.content.Intent
import com.growth.streetwarrior.custom.component.ParamsMailAndPassword


sealed class EventsSignInViewModel {
    data class loginWithEmailAndPass(val params: ParamsMailAndPassword): EventsSignInViewModel()
}

sealed class StatesSignInViewModel {
    data class OnIntentGoogleSignIn(val intent: Intent): StatesSignInViewModel()
    object ToMainActivity: StatesSignInViewModel()
    object IsLoading: StatesSignInViewModel()
}
