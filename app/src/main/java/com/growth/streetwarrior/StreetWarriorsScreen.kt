package com.growth.streetwarrior

import androidx.compose.runtime.Composable
import com.growth.streetwarrior.home.BikeCrewsBody


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
        fun fromRoute(route: String?): StreetWarriorsScreen =
            when (route?.substringBefore("/")) {
                BikeCrews.name -> BikeCrews
                null -> BikeCrews
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }

}