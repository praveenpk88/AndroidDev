package com.animedfan.adfapp.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.ui.text.font.FontWeight
import com.animedfan.adfapp.MainActivity
import com.animedfan.adfapp.R

@Composable
fun SplashScreen(navController: NavController, context: MainActivity) {

    val alpha = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true)
    {
        alpha.animateTo(
            1f,
            animationSpec = tween(2500)
        )
        delay(3000)

        if (firstTimeInstall(context = context)) {
            navController.popBackStack()
            navController.navigate("Home")
        }
        else{
            navController.popBackStack()
            navController.navigate("AppInfo")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoaderAnimation(
            modifier = Modifier.size(500.dp),
            anim = R.raw.pleasewaitanimation
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Connecting to our Server...",
            fontSize = 25.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier
                .alpha(alpha.value)
                .padding(15.dp)
        )
    }
}

@Composable
fun LoaderAnimation(modifier: Modifier, anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))

    LottieAnimation(
        composition = composition,
        iterations = 10,
        modifier = modifier
    )
}

private fun firstTimeInstall(context: MainActivity):Boolean{
    val sharedPreferences = context.getSharedPreferences("AppInfo", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("isFinished", false)
}
