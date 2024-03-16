package com.example.olympicsquest.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.olympicsquest.HomePage

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
                navArgument(name = "cityName")
                {
                    type = NavType.StringType
                },
                navArgument(name = "temp")
                {
                    type = NavType.IntType
                },
                navArgument(name = "meteo")
                {
                    type = NavType.StringType
                },
                navArgument(name = "highTemp")
                {
                    type = NavType.IntType
                },
                navArgument(name = "lowTemp")
                {
                    type = NavType.IntType
                }

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