package com.example.cupnjoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cupnjoy.data.coffeeList
import com.example.cupnjoy.presentation.navigation.NavGraph
import com.example.cupnjoy.presentation.screens.DetailsScreen
import com.example.cupnjoy.presentation.screens.OnboardingScreen
import com.example.cupnjoy.presentation.screens.TestScreen
import com.example.cupnjoy.ui.theme.CupJoyTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CupJoyTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
