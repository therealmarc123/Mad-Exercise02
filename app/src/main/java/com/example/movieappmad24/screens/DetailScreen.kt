package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.widgets.MovieImageSlider
import com.example.movieappmad24.models.movieCards.MovieRow
import com.example.movieappmad24.navigation.*
import com.example.movieappmad24.models.movieCards.MoviePlayer
import com.example.movieappmad24.viewmodels.MoviesViewModel

@Composable
fun DetailScreen(movieId: String?, navController: NavController, moviesViewModel: MoviesViewModel) {

    movieId?.let {
        val movie = moviesViewModel.movies.filter { movie -> movie.id == movieId }[0]

        Scaffold(
            topBar = {
                SimpleTopAppBar(title = movie.title) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                }
            }

        ) { padding ->

            Surface(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {

                Column {
                    MovieRow(modifier = Modifier.padding(padding), movie = movie)
                    Divider(modifier = Modifier.padding(3.dp))
                    Text(text = "Movie Trailer")
                    MoviePlayer(context = LocalContext.current)
                    Divider(modifier = Modifier.padding(3.dp))
                    MovieImageSlider(movie)
                }
            }
        }
    }
}