package com.application.newsreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.application.newsreader.screens.ArticleDetailScreen
import com.application.newsreader.screens.ArticlesScreen
import com.application.newsreader.ui.theme.NewsReaderTheme
import com.application.newsreader.viewmodels.ArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsReaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    //Shared ViewModel for Different Composable Screens
    val viewModel: ArticlesViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = "list_screen") {
        composable(route = "list_screen") {
            ArticlesScreen(navController,viewModel)
        }
        composable(route = "details") {
            ArticleDetailScreen(viewModel)
        }
    }
}
