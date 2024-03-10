package com.example.movieappmad24.models

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movieappmad24.models.movieCards.MovieList

@Composable
fun DisplayScreen()
{
    Scaffold(
        topBar = { CustomTopBar() },
        bottomBar = { CustomBottomBar() },
    )
    { padding ->
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),

            color = MaterialTheme.colorScheme.background
        ) {
            MovieList(movies = getMovies())
        }
    }
}