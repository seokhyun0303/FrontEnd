package com.example.mpproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mpproject.home.HomeScreen
import com.example.mpproject.home.SurveyResultScreen
import com.example.mpproject.login.LoginScreen
import com.example.mpproject.login.RegisterScreen
import com.example.mpproject.login.StartScreen

sealed class Route(val route: String){
    object Start: Route("Start")
    object Login: Route("Login")
    object Register: Route("Register")
    object Home: Route("Home")
    object SurveyResult: Route("SurveyResult")
}

@Composable
fun NavGraph(navController: NavHostController, startDestination: Route) {
    NavHost(navController = navController, startDestination = startDestination.route) {
        composable("Start") {
            StartScreen(navController)
        }
        composable(
            route = "Login?mail={mail}&pw={pw}",
            arguments = listOf(
                navArgument("mail") { type = NavType.StringType },
                navArgument("pw") { type = NavType.StringType }
            )
        ){
            backStackEntry ->
            val mail = backStackEntry.arguments?.getString("mail")
            val pw = backStackEntry.arguments?.getString("pw")
            LoginScreen(navController, mail, pw)
        }


        composable("Register") {
            RegisterScreen(navController)
        }
        composable("Home") {
            HomeScreen(navController)
        }

        composable("SurveyResult") {
            SurveyResultScreen(navController)
        }
    }
}