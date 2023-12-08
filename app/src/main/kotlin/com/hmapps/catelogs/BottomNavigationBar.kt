package com.hmapps.catelogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hmapps.alert.AlertScreen
import com.hmapps.cart.CartScreen
import com.hmapps.account.MeScreen
import com.hmapps.post.PostScreen
import com.hmapps.dashboard.HomeScreen

@Composable
fun BottomNavigationBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Dashboard.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            val imageModifier: Modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
                .clip(RectangleShape)

            composable(Screens.Dashboard.route) {
                HomeScreen(
                    navController, imageModifier
                )
            }
            composable(Screens.Cart.route) {
                CartScreen(
                    navController, imageModifier.background(Color.Green)
                )
            }
            composable(Screens.Post.route) {
                PostScreen(
                    navController, imageModifier.background(Color.Magenta)
                )
            }
            composable(Screens.Alerts.route) {
                AlertScreen(
                    navController, imageModifier.background(Color.Cyan)
                )
            }
            composable(Screens.Me.route) {
                MeScreen(
                    navController, imageModifier.background(Color.Blue)
                )
            }
        }
    }
}