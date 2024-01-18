package com.animedfan.adfapp.navdrawers

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.animedfan.adfapp.R
import com.animedfan.adfapp.data.DrawerItems
import com.animedfan.adfapp.downloadercomponents.AndroidDownloader
import com.animedfan.adfapp.screens.AboutOverview
import com.animedfan.adfapp.screens.ProfileScreen
import com.animedfan.adfapp.screens.ProjectsOverview
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutNavDrawer(navController: NavController) {

    val drawerItem = listOf(
        DrawerItems(Icons.Default.Home, "Home", 0, false),
        DrawerItems(Icons.Default.AccountCircle, "Profile", 0, false),
        DrawerItems(Icons.Default.Build, "Projects Overview", 10, true),
        DrawerItems(Icons.Default.Info, "About", 0, false)
    )
    var selectedItem by remember {
        mutableStateOf(drawerItem[3])
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {

                Column(
                    Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(290.dp)
//                        .background(Color(0xffffc107)),
                        .background(Color(0x3607FFF7)),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Column(
                            Modifier.wrapContentSize(),
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(painter = painterResource(id = R.drawable.navimage), contentDescription = "Profile Pic",
                                modifier = Modifier
                                    .size(190.dp)
                                    .clip(CircleShape)
                            )
                            Text(text = "Anime D.Fan",
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp),
                                fontSize = 22.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        Divider(
                            Modifier.align(Alignment.BottomCenter), thickness = 1.dp, color = Color.DarkGray
                        )
                    }
                    drawerItem.forEach{
                        NavigationDrawerItem(
                            label = {
                                Text(text = it.text,
                                    fontSize = 20.sp
//                                    fontWeight = FontWeight.Black
                                )
                            },
                            selected = it == selectedItem,
                            onClick = {
                                selectedItem = it

                                scope.launch {
                                    drawerState.close()
                                }

                                if (selectedItem.text == "Home"){
                                    navController.navigate("Home")
                                }
                                if (selectedItem.text == "Profile"){
                                    navController.navigate("Profile")
                                }
                                if (selectedItem.text == "Projects Overview"){
                                    navController.navigate("Projects Overview")
                                }
                                if (selectedItem.text == "About"){
                                    navController.navigate("About")
                                }
                            },
                            modifier = Modifier.padding(horizontal = 16.dp),
                            icon = {
                                Icon(imageVector = it.icon, contentDescription = it.text)
                            },
                            badge = {
                                if (it.hasBadge){
                                    BadgedBox(badge = {}) {
                                        Badge {
                                            Text(text = it.badgeCount.toString(), fontSize = 17.sp)
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
            }
        },
        drawerState = drawerState
    )
    {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon")
                        }
                    })
            }
        ){
            AboutOverview(navController = navController)
        }
//        { paddingValues ->
//            Box(modifier = Modifier.fillMaxSize()
//                .padding(paddingValues),
//                contentAlignment = Alignment.Center
//                )
//            {
//                Button(onClick = {
//                    scope.launch {
//                        drawerState.open()
//                    }
//                }) {
//                    Text(text = "Open Drawer")
//                }
//            }
//        }
    }
}




