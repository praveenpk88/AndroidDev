package com.animedfan.adfapp

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AppInfoScreen(navController: NavController, context: MainActivity) {
//    Box(modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center){
//        Text(text = "Onboarding Screen", fontSize = 44.sp)
//    }
    val animations = listOf(
        R.raw.loveheartsanimation,
        R.raw.dotloadinganimation,
        R.raw.fruitskateboardanimation
    )
    val title = listOf(
        "Welcome to our App homescreen",
        "Welcome ",
        "Welcome to our App"
    )

    val descriptions = listOf(
        "Description 1",
        "Description 2",
        "Description 3"
    )

    val pagerState = rememberPagerState(
        pageCount = animations.size
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.wrapContentSize()
        ) { currentPage ->
            Column(
                Modifier
                    .wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animations[currentPage]))
                LottieAnimation(composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(400.dp))
                Text(text = title[currentPage],
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 45.sp
                )
                Text(text = descriptions[currentPage],
                    modifier = Modifier.padding(top = 45.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
        
        PageIndicator(
            pageCount = animations.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier.padding(60.dp)
        )

        ButtonSection(
            pagerState = pagerState,
            navController = navController,
            context = context
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ButtonSection(pagerState: PagerState, navController: NavController, context: MainActivity) {

    val scope = rememberCoroutineScope()
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)){
        if (pagerState.currentPage != 2){
            Text(text = "Next",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clickable {
                    scope.launch {
                        val nextPage = pagerState.currentPage +1
                        pagerState.scrollToPage(nextPage)
                    }
                },
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(text = "Back",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .clickable {
                    scope.launch {
                        val previousPage = pagerState.currentPage -1
                        if (previousPage >= 0){
                            pagerState.scrollToPage(previousPage)
                        }
                    }
                },
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        else {
            OutlinedButton(onClick = {

                firstTimeInstall(context = context)
                navController.popBackStack()
                navController.navigate("Home")
            },modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x26E92F1E)
                )
                )
            {
                Text(
                    text = "Get Started",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black)
            }
        }
        }
    }


@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ){
        repeat(pageCount){
            IndicatorSingleDot(isSelected = it == currentPage)
        }
    }
}

@Composable
fun IndicatorSingleDot(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 35.dp else 15.dp, label = "")
    Box(modifier = Modifier
        .padding(2.dp)
        .height(15.dp)
        .width(width.value)
        .clip(CircleShape)
        .background(if (isSelected) Color(0xFFE92F1E) else Color(0x26E92F1E))
    )

}

private fun firstTimeInstall(context: MainActivity) {
    val sharedPreferences = context.getSharedPreferences("AppInfo", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean("isFinished", true)
    editor.apply()
}