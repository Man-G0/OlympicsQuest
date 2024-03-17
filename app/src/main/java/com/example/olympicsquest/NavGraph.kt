package com.example.olympicsquest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController , startDestination = Screen.Home.route){
        composable(
            route = Screen.Home.route
        ){
            ContentHomePage(navController = navController)
        }
        composable(
            route = Screen.SportPage.route,
            arguments = listOf(
                navArgument(name = "sport")
                {
                    type = NavType.StringType
                },
                navArgument(name = "epreuve")
                {
                    type = NavType.StringType
                },
                navArgument(name = "session")
                {
                    type = NavType.StringType
                },
                navArgument(name = "date")
                {
                    type = NavType.StringType
                },
                navArgument(name = "lieu")
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
                navArgument(name = "geo_point")
                {
                    type = NavType.StringType
                }

            )
        ) {navBackStackEntry ->
            val sport = navBackStackEntry.arguments?.getString("sport")
            val epreuve = navBackStackEntry.arguments?.getString("epreuve")
            val session = navBackStackEntry.arguments?.getString("session")
            val date = navBackStackEntry.arguments?.getString("date")
            val lieu = navBackStackEntry.arguments?.getString("lieu")
            val startTime = navBackStackEntry.arguments?.getString("startTime")
            val endTime = navBackStackEntry.arguments?.getString("endTime")
            val geo_point = navBackStackEntry.arguments?.getString("geo_point")
            BackgroundSportPage(sport,epreuve,session,date,lieu,startTime,endTime,geo_point,navController = navController)


        }
    }
}

