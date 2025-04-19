package com.example.taller_2.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationStack(){
    val navController = rememberNavController()
    val screens = listOf(
        Screen.Home,
        Screen.Picture,
        Screen.Map
    )
    Box(){
        NavHost(navController = navController, startDestination = Screen.Home.route){
            screens.forEach{ screen ->
                composable(route = screen.route){
                    when (screen){
                        is Screen.Home      -> HomeScreen(navController)
                        is Screen.Picture   -> PictureScreen()
                        is Screen.Map       -> MapScreen()
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String){
    object Home     :   Screen("home")
    object Picture  :   Screen("picture")
    object Map      :   Screen("map")
}