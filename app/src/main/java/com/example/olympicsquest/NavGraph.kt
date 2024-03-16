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
            route = Screen.SportPage.route,
            arguments = listOf(

                navArgument(name = "name")
                {
                    type = NavType.StringType
                },
                navArgument(name = "startTime")
                {
                    type = NavType.StringType
                },
                navArgument(name = "endTime")
                {
                    type = NavType.StringType
                },
                navArgument(name = "cession")
                {
                    type = NavType.StringType
                },
                navArgument(name = "localisation")
                {
                    type = NavType.StringType
                }

            )
        ) {navBackStackEntry ->
            val events = navBackStackEntry.arguments?.getString("cityName")
            val name = navBackStackEntry.arguments?.getString("name")
            val startTime = navBackStackEntry.arguments?.getString("startTime")
            val endTime = navBackStackEntry.arguments?.getString("endTime")
            val cession = navBackStackEntry.arguments?.getString("cession")
            val localisation = navBackStackEntry.arguments?.getString("localisation")
            //SportPage(events,name,startTime,endTime,cession,localisation,navController = navController)
        }
    }
}