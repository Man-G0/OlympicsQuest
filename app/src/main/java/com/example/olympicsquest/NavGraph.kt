package com.example.olympicsquest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.olympicsquest.HomePage
import com.example.olympicsquest.Screen

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController , startDestination = Screen.Home.route){
        composable(
            route = Screen.Home.route
        ){
            HomePage(navController = navController)
        }
        composable(
            route = Screen.Meteo.route,
            arguments = listOf(
                navArgument(name = "events")
                {
                    type = NavType.ParcelableType(Screen::class.java)
                },

            )
        ) {navBackStackEntry ->
            val cityName = navBackStackEntry.arguments?.getString("cityName")
            val temp = navBackStackEntry.arguments?.getInt("temp")
            val meteo = navBackStackEntry.arguments?.getString("meteo")
            val highTemp = navBackStackEntry.arguments?.getInt("highTemp")
            val lowTemp = navBackStackEntry.arguments?.getInt("lowTemp")
            //MeteoPage(cityName,temp,meteo,highTemp,lowTemp,navController = navController)
        }
    }
}