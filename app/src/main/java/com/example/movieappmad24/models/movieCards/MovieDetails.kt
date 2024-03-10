package com.example.movieappmad24.models.movieCards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.models.Movie

@Composable
fun MovieDetails(movie: Movie)
{
    Column(modifier = Modifier.padding(6.dp))
    {
        Text(text = "Director: ${movie.director}")
        Text(text = "Released: ${movie.year}")
        Text(text = "Genre: ${movie.genre}")
        Text(text = "Actors: ${movie.actors}")
        Text(text = "Rating: ${movie.rating}")
        Divider(modifier = Modifier.padding(3.dp))
        Text(text = "Plot: ${movie.plot}")
    }
}