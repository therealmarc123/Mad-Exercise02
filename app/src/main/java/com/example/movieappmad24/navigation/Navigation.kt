package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen


sealed class AppScreen(val route: String) {
    data object Main: AppScreen("home")
    data object MovieDetail: AppScreen("detail/{movieId}") {
        fun routeWithId(movieId: String) = "detail/$movieId"
    }
    data object Watchlist: AppScreen("watchlist")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.Main.route) {
        composable(route = AppScreen.Main.route){
            HomeScreen(navController = navController)
        }

        composable(
            route = AppScreen.MovieDetail.route,
            arguments = listOf(navArgument(name = "movieId") {type = NavType.StringType})
        ) { navBackStackEntry ->
            DetailScreen(movieId = navBackStackEntry.arguments?.getString("movieId"), navController)
        }

        composable(route = AppScreen.Watchlist.route) {
            WatchlistScreen(navController = navController)
        }
    }
}
