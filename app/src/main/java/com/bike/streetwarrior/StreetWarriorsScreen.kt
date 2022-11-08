package com.bike.streetwarrior

import androidx.compose.runtime.Composable
import com.bike.streetwarrior.home.BikeCrewsBody


enum class StreetWarriorsScreen(
    val body: @Composable ((String)-> Unit) -> Unit
) {
    BikeCrews(
        body = { BikeCrewsBody()}
    );


    @Composable
    fun content(onScreenChange: (String) -> Unit) {
        body(onScreenChange)
    }

    companion object {
        fun fromRoute(route: String?): com.bike.streetwarrior.StreetWarriorsScreen =
            when (route?.substringBefore("/")) {
                com.bike.streetwarrior.StreetWarriorsScreen.BikeCrews.name -> com.bike.streetwarrior.StreetWarriorsScreen.BikeCrews
                null -> com.bike.streetwarrior.StreetWarriorsScreen.BikeCrews
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }

}