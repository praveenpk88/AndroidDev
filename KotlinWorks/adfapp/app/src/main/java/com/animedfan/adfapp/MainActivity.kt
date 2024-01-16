package com.animedfan.adfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.animedfan.adfapp.ui.theme.AdfappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdfappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

//                    MyApp()

                    NavHost(navController = navController, startDestination = "Home") {
                        composable("Splash"){
                            SplashScreen(navController = navController, context = this@MainActivity)
                        }
                        composable("AppInfo"){
                            AppInfoScreen(navController = navController, context = this@MainActivity)
                        }
                        composable("Home"){
                            HomeScreen(navController = navController)
                        }
                        composable("Profile"){
                            HomeScreen(navController = navController)
                        }
                        composable("Projects Overview"){
                            HomeScreen(navController = navController)
                        }
                        composable("About"){
                            HomeScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.bikedriveanimation))
        var isPlaying by remember{
            mutableStateOf(true)
        }
        val progress by animateLottieCompositionAsState(
            composition = composition,
            isPlaying = isPlaying
        )
        LaunchedEffect(key1 = progress){
            if (progress == 0f){
                isPlaying = true
            }
            if (progress == 1f){
                isPlaying = false
            }
        }
        LottieAnimation(composition = composition,
            modifier = Modifier
                .size(1000.dp)
                .clickable {
                    isPlaying = true
                },
            iterations = 2
//            progress = {
//                progress
//            }
                 )
    }
}