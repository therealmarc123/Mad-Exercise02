package com.example.movieappmad24.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar()
{
    CenterAlignedTopAppBar(
        title = { Text("Movie App") }
    )
}

@Composable
fun CustomBottomBar()
{
    NavigationBar {
        val navItems = mapOf("Home" to Icons.Filled.Home, "Watchlist" to Icons.Filled.Star)
        navItems.forEach { (label, icon) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(text = label) },
                selected = label == navItems.keys.first(),
                onClick = { /* Action */ }
            )
        }
    }
}