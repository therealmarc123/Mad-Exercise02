package com.example.movieappmad24.models.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.models.movieCards.MovieList
import com.example.movieappmad24.navigation.*
import com.example.movieappmad24.models.getMovies

@Composable
fun WatchlistScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopBar(title = "Your Watchlist")
                 },
        bottomBar = {
            CustomBottomBar(navController)
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MovieList(
                movies = getMovies(),
                navController = navController
            )
        }
    }
}