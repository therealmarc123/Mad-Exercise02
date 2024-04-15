package com.example.movieappmad24.models.movieCards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie

@Composable
fun DisplayPoster(movie: Movie)
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),

        contentAlignment = Alignment.Center
    )
    {
        DisplayPoster(movie.title, movie.images)
    }
}

@Composable
fun DisplayPoster(title: String, images: List<String>)
{
    if (images.isNotEmpty())
    {
        val selectedImage = remember{ images.random() }
        AsyncImage(
            modifier = Modifier.fillMaxSize(),

            contentScale = ContentScale.Crop,
            model = selectedImage,
            contentDescription = title,
        )
    }
}

