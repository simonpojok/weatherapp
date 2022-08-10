package me.simonpojok.weatherapp.common.navigation

import androidx.navigation.NavController

interface UiDestination {
    fun navigate(navController: NavController)
}
