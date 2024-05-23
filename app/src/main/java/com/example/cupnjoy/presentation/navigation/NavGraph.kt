package com.example.cupnjoy.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cupnjoy.data.Coffee
import com.example.cupnjoy.presentation.screens.DetailsScreen
import com.example.cupnjoy.presentation.screens.HomeScreen
import com.example.cupnjoy.presentation.screens.OnboardingScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screens.OnboardingScreen.route) {

        composable(
            route = Screens.OnboardingScreen.route
        ) {
            OnboardingScreen(navController)
        }

        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(navController)
        }

        composable(
            route = Screens.DetailsScreen.route

        ) {

            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Coffee>("coffeeInfo")

            if (result != null) {
                DetailsScreen(navController, result)
            }
        }
    }
}