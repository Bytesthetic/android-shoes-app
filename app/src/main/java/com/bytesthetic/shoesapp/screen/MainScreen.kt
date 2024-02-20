package com.bytesthetic.shoesapp.screen

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bytesthetic.shoesapp.viewmodel.SharedViewModel

const val HOME_SCREEN = "Home"
const val PRODUCT_DETAILS_SCREEN ="Details"
private const val TRANSITION_UP_DURATION = 350
private const val TRANSITION_DOWN_DURATION = 250

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = HOME_SCREEN
    ) {
        composable(
            HOME_SCREEN
        ) {
            HomeScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            PRODUCT_DETAILS_SCREEN,
            enterTransition = {
                fadeIn(animationSpec = tween(TRANSITION_UP_DURATION)) + slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up, tween(TRANSITION_UP_DURATION)
                )
            },
            exitTransition = {
                fadeOut(animationSpec = tween(TRANSITION_DOWN_DURATION)) + slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down, tween(TRANSITION_DOWN_DURATION)
                )
            }
        ) {
            ProductDetailsScreen(viewModel = viewModel, navController = navController)
        }
    }
}