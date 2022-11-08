package com.bike.streetwarrior.presentation.ui.groupmotorbikershandle.listofgroups

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bike.streetwarrior.presentation.RouteNavigator
import com.bike.streetwarrior.usecases.GetUserInfoUseCase
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListOfGroupsViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator,
    private val firebaseAuth: FirebaseAuth
): ViewModel(), RouteNavigator by routeNavigator {

    init {


    }

}

