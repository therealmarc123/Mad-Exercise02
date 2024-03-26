package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.models.movieCards.MovieList

import androidx.navigation.NavController
import com.example.movieappmad24.navigation.*

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { SimpleTopAppBar() },
        bottomBar = { SimpleBottomAppBar(navController) }
    ) { padding ->
        Surface(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),

            color = MaterialTheme.colorScheme.background
        ) {
            MovieList(movies = getMovies(),
                navController = navController
            )
        }
    }
}

