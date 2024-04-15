package com.example.movieappmad24.models.movieCards

import android.content.Context
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
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.viewmodels.MoviesViewModel
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.movieappmad24.R




@Composable
fun MovieList(modifier: Modifier, movies: List<Movie>, navController: NavController, viewModel: MoviesViewModel) {
    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie = movie,
                onLikeClick = {movieId ->
                    viewModel.toggleLikeMovie(movieId)
                },
                onItemClick = { movieId ->
                    navController.navigate(route = Screen.DetailScreen.withId(movieId))
                }
            )
            }
        }
    }


@Composable
fun MovieRow(    modifier: Modifier = Modifier,
                 movie: Movie,
                 onLikeClick: (String) -> Unit = {},
                 onItemClick: (String) -> Unit = {}) {
    var showDetails by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clickable {
                onItemClick(movie.id)
            },

        shape = ShapeDefaults.Large,
        elevation = CardDefaults.cardElevation(10.dp)
    )
    {
        Column {
            CardHeader(
                isLiked = movie.isLiked,
                onLikeClick = { onLikeClick(movie.id) },
                posterUrl = movie.images[0]
            )

            MovieDetails(modifier = modifier.padding(12.dp), movie = movie)
            }
        }
    }

@Composable
fun CardHeader(
    posterUrl: String,
    isLiked: Boolean = false,
    onLikeClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        MoviePoster(posterUrl)
        MovieLike(isLiked = isLiked, onLikeClick)
    }
}

@Composable
fun MoviePoster(imageUrl: String){
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "movie poster",
        contentScale = ContentScale.Crop,
        loading = {
            CircularProgressIndicator()
        }
    )
}

@Composable
fun MoviePlayer(
    context: Context,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
) {
    val placeholderUri = "android.resource://${context.packageName}/${R.raw.trailer_placeholder}"
    val playbackMedia = MediaItem.fromUri(placeholderUri)

    val player = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(playbackMedia)
            prepare()
        }
    }
    val playerLifecycleHandler = rememberPlayerLifecycleHandler(player, lifecycleOwner)

    MovieContent(player = player)

    DisposableEffect(player, playbackMedia) {
        player.setMediaItem(playbackMedia)
        player.prepare()

        onDispose {
            player.release()
        }
    }

    DisposableEffect(lifecycleOwner) {
        lifecycleOwner.lifecycle.addObserver(playerLifecycleHandler)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(playerLifecycleHandler)
        }
    }
}

@Composable
private fun rememberPlayerLifecycleHandler(player: ExoPlayer, lifecycleOwner: LifecycleOwner): LifecycleEventObserver {
    return remember {
        LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> player.play()
                Lifecycle.Event.ON_PAUSE -> player.pause()
                Lifecycle.Event.ON_STOP -> player.stop()
                Lifecycle.Event.ON_DESTROY -> player.release()
                else -> Unit
            }
        }
    }
}

@Composable
fun MovieContent(player: ExoPlayer) {
    LazyRow {
        item {
            AndroidView(
                factory = { context ->
                    PlayerView(context).apply {
                        layoutParams = FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.MATCH_PARENT,
                            FrameLayout.LayoutParams.MATCH_PARENT
                        )
                        this.player = player
                    }
                },
                modifier = Modifier.width(393.dp).height(250.dp)
            )
        }
    }
}
