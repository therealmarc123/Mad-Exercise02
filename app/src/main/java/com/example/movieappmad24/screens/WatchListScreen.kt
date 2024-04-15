package com.example.movieappmad24.screens

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
import com.example.movieappmad24.viewmodels.MoviesViewModel

@Composable
fun WatchlistScreen(navController: NavController,
                    moviesViewModel: MoviesViewModel
) {
    Scaffold(
        topBar = {
            SimpleTopAppBar(title = "Your Watchlist")
                 },
        bottomBar = {
            SimpleBottomAppBar(navController)
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MovieList(
                modifier = Modifier.padding(padding),
                movies = moviesViewModel.likedMovies,
                navController = navController,
                viewModel = moviesViewModel
            )
        }
    }
}