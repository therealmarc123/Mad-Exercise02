package com.example.movieappmad24.models.movieCards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieLike()
{
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),

        contentAlignment = Alignment.TopEnd
    )
    {
        Icon(
            tint = MaterialTheme.colorScheme.secondary,
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "Like this Movie"
        )
    }
}