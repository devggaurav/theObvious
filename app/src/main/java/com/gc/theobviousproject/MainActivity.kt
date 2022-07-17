package com.gc.theobviousproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gc.theobviousproject.presentation.ShowImagesGrid
import com.gc.theobviousproject.presentation.SwipeImages
import com.gc.theobviousproject.ui.theme.TheObviousProjectTheme
import com.gc.theobviousproject.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheObviousProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.GRID_SCREEN) {

                        composable(Routes.GRID_SCREEN) {
                            ShowImagesGrid(navController = navController)
                        }
                        composable(
                            Routes.SWIPE_SCREEN+"/{position}",
                            arguments = listOf(navArgument("position") { type = NavType.IntType })
                        ) {
                            val position = it.arguments?.getInt("position")
                            SwipeImages(navController = navController, position = position)
                        }

                    }


                    // SwipeImages()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TheObviousProjectTheme {
        Greeting("Android")
    }
}