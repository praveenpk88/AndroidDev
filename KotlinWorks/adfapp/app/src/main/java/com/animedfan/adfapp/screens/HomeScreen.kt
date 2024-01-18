package com.animedfan.adfapp.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.animedfan.adfapp.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavController) {

    val images = listOf(
        R.drawable.profile,
        R.drawable.projectoverview,
        R.drawable.aboutus
    )

    val pagerState = rememberPagerState(
        pageCount =
        images.size
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000L)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.scrollToPage(nextPage)
        }
    }

    val scope = rememberCoroutineScope()

    Column (modifier = Modifier.fillMaxSize(),
//        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){
        Box(modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth()
            .height(390.dp)
            .background(Color(0x734CAF50)),
//                        .background(Color(0x3607FFF7)),
            contentAlignment = Alignment.Center
        )
        {
            Column(
                Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.new_image), contentDescription = "Profile Pic",
                    modifier = Modifier
                        .size(260.dp)
                        .clip(CircleShape)
                        .clickable {
                            navController.navigate("Profile")
                        }
                )
                Text(text = "Praveen Kumar S",
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Automation Developer",
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }

    }
        Spacer(modifier = Modifier.size(20.dp))

        Text(text = "The objective of this application is to present my portfolio and share insights gained in the realm of Android application development.",
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            fontSize = 22.5.sp,
            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.W900,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.size(30.dp))

        Text(text = "Please navigate through the provided cards or use the top-left navigation drawer to explore different sections of the application.",
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
//                .height(5.dp)
//                .padding(top = 5.dp),
            fontSize = 22.5.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            val modifier = Modifier
            Box(modifier = modifier.wrapContentSize()) {
                HorizontalPager(
                    state = pagerState,
                    modifier
                        .wrapContentSize()
                ) { currentPage ->

                    Card(
                        modifier
                            .wrapContentSize()
                            .padding(26.dp)
                            .clickable {
                                if (currentPage == 0) {
                                    navController.navigate("Profile")
                                }
                                if (currentPage == 1) {
                                    navController.navigate("Projects Overview")
                                }
                                if (currentPage == 2) {
                                    navController.navigate("About")
                                }
                            },
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = images[currentPage]),
                            contentDescription = ""
                        )
                    }
                }

                IconButton(
                    onClick = {
                        val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                        if (nextPage < images.size) {
                            scope.launch {
                                pagerState.scrollToPage(nextPage)
                            }
                        }
                    },
                    modifier
                        .padding(30.dp)
                        .size(48.dp)
                        .align(Alignment.CenterEnd)
                        .clip(CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "",
                        modifier.fillMaxSize(),
                        tint = Color.Black
                    )

                }
                IconButton(
                    onClick = {
                        val prevPage =
                            if (pagerState.currentPage == 0) pagerState.pageCount - 1 else pagerState.currentPage - 1
                        if (prevPage >= 0) {
                            scope.launch {
                                pagerState.scrollToPage(prevPage)
                            }
                        }
                    },
                    modifier
                        .padding(30.dp)
                        .size(48.dp)
                        .align(Alignment.CenterStart)
                        .clip(CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                        modifier.fillMaxSize(),
                        tint = Color.Black
                    )
                }
            }
            //        Spacer(modifier = modifier.size(10.dp))
            HomePageIndicator(
                pageCount = images.size,
                currentPage = pagerState.currentPage,
                modifier = modifier
            )
            Spacer(modifier = modifier.size(20.dp))
        }
    }
}

@Composable
fun HomePageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        repeat(pageCount){
            IndicatorDots(isSelected = it == currentPage, modifier)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier) {
    val size = animateDpAsState(targetValue = if (isSelected) 12.dp else 10.dp , label = "")
    Box(modifier = modifier
        .padding(2.dp)
        .size(size.value)
        .clip(CircleShape)
        .background(if (isSelected) Color(0xff373737) else Color(0x33373737))
    ){}
}

