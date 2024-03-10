package com.example.movieappmad24.models.movieCards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.models.Movie

@Composable
fun InformationBox(movie: Movie, showDetails: Boolean, onToggleShowDetails: () -> Unit)
{
    Row(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(text = movie.title)
        ToggleExpandIcon(showDetails, onToggleShowDetails)
    }
}

@Composable
fun ToggleExpandIcon(showDetails: Boolean, onClick: () -> Unit)
{
    Icon(
        modifier = Modifier.clickable { onClick() },
        imageVector = if (showDetails) Icons.Filled.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
        contentDescription = "Show more"
    )
}
