package com.growth.streetwarrior.presentation.ui.groupmotorbikershandle.listofgroups

import androidx.lifecycle.ViewModel
import com.growth.streetwarrior.presentation.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListOfGroupsViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator
): ViewModel(), RouteNavigator by routeNavigator {

}

