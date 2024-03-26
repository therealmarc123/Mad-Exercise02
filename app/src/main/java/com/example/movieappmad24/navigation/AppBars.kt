package com.example.movieappmad24.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.movieappmad24.navigation.AppScreen.Main.route


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(title: String = "Movie App", navController: NavController? = null) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            if (navController != null)
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Navigate Back"
                    )
                }
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavController) {
    val navigationItems = listOf(
        NavigationItem("Home", Icons.Filled.Home, "Go to Home", AppScreen.Main.route),
        NavigationItem("Watchlist", Icons.Filled.Star, "Go to Watchlist", AppScreen.Watchlist.route)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        navigationItems.forEach { navItem ->
            NavigationBarItem(
                icon = { Icon(navItem.icon, contentDescription = navItem.description) },
                label = { Text(navItem.title) },
                selected = false,
                onClick = { navController.navigate(navItem.route) }
            )
        }
    }
}

data class NavigationItem(val title: String, val icon: ImageVector, val description: String, val route: String)