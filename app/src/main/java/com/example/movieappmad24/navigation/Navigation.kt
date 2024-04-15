package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen
import com.example.movieappmad24.viewmodels.MoviesViewModel


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

    val moviesViewModel: MoviesViewModel = viewModel()

    NavHost(navController = navController, startDestination = AppScreen.Main.route) { composable(route = AppScreen.Main.route){
            HomeScreen(navController = navController, moviesViewModel = moviesViewModel)
        }

        composable(
            route = AppScreen.MovieDetail.route,
            arguments = listOf(navArgument(name = DETAIL_ARGUMENT_KEY) {type = NavType.StringType})
        ) { navBackStackEntry ->
            DetailScreen(navController = navController, movieId = navBackStackEntry.arguments?.getString(DETAIL_ARGUMENT_KEY), moviesViewModel = moviesViewModel)
        }

        composable(route = AppScreen.Watchlist.route) {
            WatchlistScreen(navController = navController,moviesViewModel = moviesViewModel)
        }
    }
}
