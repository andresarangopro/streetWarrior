package com.growth.streetwarrior.presentation.navigation.di

import com.growth.streetwarrior.presentation.StreetRouteNavigator
import com.growth.streetwarrior.presentation.RouteNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun bindRouteNavigator(): RouteNavigator = StreetRouteNavigator()
}