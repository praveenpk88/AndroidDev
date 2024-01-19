package com.animedfan.adfapp.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
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
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.animedfan.adfapp.R
import com.animedfan.adfapp.downloadercomponents.AndroidDownloader
import com.google.accompanist.pager.ExperimentalPagerApi



@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProfileScreen(navController: NavController, downloader: AndroidDownloader) {
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top)
    {
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .height(390.dp)
                .background(Color(0x4D009688)),
            //                        .background(Color(0x3607FFF7)),
            contentAlignment = Alignment.Center
        )
        {
            Column(
                Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.new_image),
                    contentDescription = "Profile Pic",
                    modifier = Modifier
                        .size(260.dp)
                        .clip(CircleShape)
                        .clickable {
                            navController.navigate("Profile")
                        }
                )
                Text(
                    text = "Praveen Kumar S",
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Automation Developer",
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    fontSize = 22.5.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Professional Overview",
                Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                fontSize = 22.5.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Bringing over 2 years of experience as a DevOps Engineer specializing in the configuration management domain.\n\n I have played a pivotal role in developing and deploying automation solutions for system configurations, security setups, and network configurations on both Windows and Linux machines.\n\nFurthermore, I have actively contributed to the development of serverless web applications using AWS Lambda. My skill set includes over 2 years of hands-on experience with configuration management tools like Ansible and Puppet, complemented by proficiency in Python programming.\n\nYou can review my detailed resume by clicking the button below.",
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                //            fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(3.dp),
                contentAlignment = Alignment.Center
            )
            {
                Button(onClick = {
                    //                    downloader.downloadFile("https://drive.usercontent.google.com/u/0/uc?id=1OOLcYBB2JHSxTz4G5Xs9m54p9CzKCu3e&export=download")
                }) {
                    Text(text = "Resume")
                }
            }

            Spacer(modifier = Modifier.size(5.dp))

            Divider(thickness = 2.5.dp)
            Spacer(modifier = Modifier.size(3.dp))
            Divider(thickness = 2.5.dp)

            Spacer(modifier = Modifier.size(15.dp))

            Text(
                text = "Personal Overview",
                Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                fontSize = 22.5.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "I am currently engaged in learning to build Android apps using both Kotlin and Flutter. For more updates and information, please utilize the cards below to follow my journey.",
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                //            fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(30.dp))

            Row(modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val uriHandler = LocalUriHandler.current
//                Button(onClick = {
//                        uriHandler.openUri("https://www.linkedin.com/in/praveenkumarpk08/")
//                }) {
//                    Text(text = "LinkedIn")
//                }
                CustomButtons(name = "LinkedIn", url = "https://www.linkedin.com/in/praveenkumarpk08/")
                CustomButtons(name = "GitHub", url = "https://github.com/praveenpk88")
                CustomButtons(name = "Twitter", url = "https://twitter.com/Anime_Fan08")
//                Button(onClick = {
//                    uriHandler.openUri("https://github.com/praveenpk88")
//
//                }) {
//                    Text(text = "GitHub")
//                }
//                Button(onClick = {
//                    uriHandler.openUri("https://twitter.com/Anime_Fan08")
//                }) {
//                    Text(text = "Twitter")
//                }
            }

            Spacer(modifier = Modifier.size(15.dp))

            Divider(thickness = 2.5.dp)
            Spacer(modifier = Modifier.size(3.dp))
            Divider(thickness = 2.5.dp)
        }
    }
}

@Composable
fun CustomButtons(name: String ,url: String) {
    val ctx = LocalContext.current
    Button(
        onClick = {
        openTab(ctx,url)
    },
        ) {
            Text(text = name)
    }
}

fun openTab(ctx: Context, url: String) {
    val package_name = "com.android.chrome"
    val activity = (ctx as? Activity)
    val builder = CustomTabsIntent.Builder()
    builder.setShowTitle(true)
    builder.setInstantAppsEnabled(true)
    val customBuilder = builder.build()
    if (package_name != null) {
        customBuilder.intent.setPackage(package_name)
        customBuilder.launchUrl(ctx, Uri.parse(url))
    } else {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        activity?.startActivity(i)
    }
}
