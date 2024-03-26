package com.example.movieappmad24.models.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.Column
import androidx.navigation.NavController
import com.example.movieappmad24.models.widgets.MovieImageSlider
import com.example.movieappmad24.models.movieCards.MovieRow
import com.example.movieappmad24.navigation.*
import com.example.movieappmad24.models.getMovies

@Composable
fun DetailScreen(movieId: String?, navController: NavController) {
    if (movieId != null) {
        val movie = getMovies().find { it.id == movieId }
        if (movie != null) {
            Scaffold(
                topBar = {
                    CustomTopBar(title = movie.title, navController = navController)
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
                    Column {
                        MovieRow(movie)
                        MovieImageSlider(movie)
                    }
                }
            }
        }
    }
}