package com.crewl.pentidemo.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crewl.pentidemo.ui.ColorScreen
import com.crewl.pentidemo.ui.FiltersScreen
import com.crewl.pentidemo.ui.PriceScreen

@Composable
fun SetupNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.FilterScreen.route,
        builder = {
            composable(route = Screen.FilterScreen.route) {
                FiltersScreen(navigator = navController)
            }

            composable(route = Screen.PriceScreen.route) {
                PriceScreen(navigator = navController)
            }

            composable(route = Screen.ColorScreen.route) {
                ColorScreen(navigator = navController)
            }
        }
    )
}