package com.animedfan.adfapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProjectsOverview(navController: NavController) {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .height(420.dp)
//                .background(Color(0x4D009688)),
                .background(Color(0x3607FFF7)),
            contentAlignment = Alignment.Center
        )
        {
            Column(
                Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Flutter Projects",
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "For more information on Flutter-related projects, please utilize the button below to navigate to our GitHub repository for Flutter projects.",
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    fontSize = 22.5.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.size(50.dp))
                Button(onClick = {
                    uriHandler.openUri("https://github.com/praveenpk88/AndroidDev/tree/main/FlutterWorks")
                },
                    colors = ButtonDefaults.buttonColors(Color(0xFF01DBD4)),
                    modifier = Modifier.scale(1.375F)) {
                    Text(text = "Flutter Projects GitHub Repository")
                }
            }

        }
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .height(420.dp)
                .background(Color(0x4D932BDD)),
            //                        .background(Color(0x3607FFF7)),
            contentAlignment = Alignment.Center
        )
        {
            Column(
                Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Kotlin Projects",
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "For more information on Kotlin-related projects, please utilize the button below to navigate to our GitHub repository for Kotlin projects.",
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    fontSize = 22.5.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(50.dp))
                Button(onClick = {
                    uriHandler.openUri("https://github.com/praveenpk88/AndroidDev/tree/main/KotlinWorks")
                },
                    colors = ButtonDefaults.buttonColors(Color(0xFF932BDD)),
                    modifier = Modifier.scale(1.375F)) {
                    Text(text = "Kotlin Projects GitHub Repository")
                }
            }

        }
    }
}