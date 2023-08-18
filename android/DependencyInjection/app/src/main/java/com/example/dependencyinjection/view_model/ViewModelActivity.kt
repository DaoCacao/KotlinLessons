package com.example.dependencyinjection.view_model

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dependencyinjection.view_model.navigator.Screen
import com.example.dependencyinjection.view_model.state.StateScreen
import dagger.hilt.android.AndroidEntryPoint

// Single activity
// Intent (system calls)
// FragmentManager (add/replace/remove/hide/show)
// Navigation Component (graph)
// Jetpack Compose Navigation
@AndroidEntryPoint
class ViewModelActivity : ComponentActivity() {

    enum class Routes(val route: String) {
        SCREEN_STATE("state"),
        SCREEN_1("screen_1"),
        SCREEN_2("screen_2/{argument}"),
        SCREEN_3("screen_3?argument={argument}"),
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Routes.SCREEN_STATE.route,
            ) {
                Routes.values().forEach {
                    when (it) {
                        Routes.SCREEN_STATE -> {
                            composable(it.route) {
                                StateScreen()
                            }
                        }

                        Routes.SCREEN_1 -> {
                            composable(it.route) {
                                Screen(
                                    title = "Screen 1",
                                    action = "Next to 2",
                                    onNextScreenClick = {
                                        navController.navigate("screen_2/asd")
                                    },
                                )
                            }
                        }

                        Routes.SCREEN_2 -> {
                            composable(it.route) {
                                val argument = it.arguments?.getString("argument")
                                Screen(
                                    title = "Screen 2 ($argument)",
                                    action = "Next to 3",
                                    onNextScreenClick = { navController.navigate("screen_3") },
                                )
                            }
                        }

                        Routes.SCREEN_3 -> {
                            composable(
                                route = it.route,
                                arguments = listOf(navArgument("argument") {
                                    type = NavType.StringType
                                    defaultValue = "default value"
                                })
                            ) {
                                val argument = it.arguments?.getString("argument")
                                Screen(
                                    title = "Screen 3 ($argument)",
                                    action = "Next to 1",
                                    onNextScreenClick = {
                                        navController.navigate("screen_1") {
                                            popUpTo("screen_1") { inclusive = true }
                                        }
                                    },
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}