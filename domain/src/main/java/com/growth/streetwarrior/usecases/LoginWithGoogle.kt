package com.growth.streetwarrior.usecases

import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.growth.streetwarrior.DefaultClientID.defaultClientId


class LoginWithGoogle(val context: Context) {
    lateinit var mGoogleSignInClient: GoogleSignInClient

    val req_Code:Int=123
    val firebaseAuth = FirebaseAuth.getInstance()

    // Configure Google Sign In inside onCreate mentod
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(defaultClientId)
        .requestEmail()
        .build()


    private  fun signInGoogle(): Intent{
        mGoogleSignInClient = GoogleSignIn.getClient(context,gso)
        return mGoogleSignInClient.signInIntent
    }

}