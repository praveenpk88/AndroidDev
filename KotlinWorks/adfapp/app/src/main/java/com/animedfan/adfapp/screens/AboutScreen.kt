package com.animedfan.adfapp.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.animedfan.adfapp.R

@Composable
fun AboutOverview(navController: NavController) {
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    var text by remember { mutableStateOf("praveenkumarsaravanan88@gmail.com")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .height(450.dp),
//                .background(Color(0x4D009688)),
//                .background(Color(0x3607FFF7)),
            contentAlignment = Alignment.Center
        )
            {
                Column(
                    Modifier.wrapContentSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.hubhero),
                        contentDescription = "Build In-Progress",
                        modifier = Modifier
                            .size(390.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "Application Update",
                        Modifier
//                            .padding(top = 5.dp),
                            .fillMaxWidth(),
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
        }
        Text(
            text = "The application is currently in development,and we are committed to delivering a new feature drop approximately every two weeks.",
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            //            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Important News",
            Modifier
//                            .padding(top = 5.dp),
                .fillMaxWidth(),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Regrettably, the resume download button is temporarily disabled due to backend issues. Our team is actively addressing this matter and working on a resolution.",
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            //            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "User Experience",
            Modifier
//                            .padding(top = 5.dp),
                .fillMaxWidth(),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Please inform us if you encounter any bugs or experience other issues in the user experience by sending us an email.\n\n Please use the below mentioned mail to drop any issue/suggestions.",
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            //            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(20.dp))
        Row(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                value = text,
                label = {
                    Text(
                        text = "Our Email"
                    )
                        },
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
                onValueChange = {text})
            Button(onClick = {
                clipboardManager.setText(AnnotatedString((text)))
            }) {
                Text("Copy")
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
    }
}