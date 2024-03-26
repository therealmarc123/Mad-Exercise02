package com.example.movieappmad24.models.movieCards

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.AppScreen


@Composable
fun MovieList(movies: List<Movie> = getMovies(), navController: NavController) {
    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie) {
                navController.navigate(AppScreen.MovieDetail.routeWithId(movieId = movie.id))
            }
        }
    }
}


@Composable
fun MovieRow(movie: Movie, onItemClick: (Movie) -> Unit = {}) {
    var showDetails by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clickable {
                onItemClick(movie)
            },

        shape = ShapeDefaults.Large,
        elevation = CardDefaults.cardElevation(10.dp)
    )
    {
        Column {
            DisplayPoster(movie)
            InformationBox(movie, showDetails) { showDetails = !showDetails }
            AnimatedVisibility(visible = showDetails) {
                MovieDetails(movie)
            }
        }
    }
}
