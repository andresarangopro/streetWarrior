package com.growth.streetwarrior.presentation.ui.login.createAccount

import android.content.Intent
import com.growth.streetwarrior.custom.component.ParamsCreateAccount

data class CreateAccountViewModelState(
    val title: String,
    val counterValue: Int,
)

data class ParamsCreateAccountViewModel(
    val mail: String,
    val password: String,
    val verifyPassword: String
)

sealed class EventsCreateAccountViewModel {
    data class CreateAccountWithEmailAndPass(val params: ParamsCreateAccountViewModel): EventsCreateAccountViewModel()
}

sealed class StatesCreateAccountViewModel {
    data class OnIntentGoogleSignIn(val intent: Intent): StatesCreateAccountViewModel()
    object ToCreateBikeScreen: StatesCreateAccountViewModel()
    object IsLoading: StatesCreateAccountViewModel()
}