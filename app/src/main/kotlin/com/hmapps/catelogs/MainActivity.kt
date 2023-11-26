package com.hmapps.catelogs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hmapps.account.MyAccount
import com.hmapps.catelogs.ui.theme.MyCatelogTheme
import com.hmapps.dashboard.Dashboard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCatelogTheme {
                BottomNavFrame("Home")
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavFrame(name: String, modifier: Modifier = Modifier) {
    val screens = listOf("Dashboard", "Cart", "Post", "Alerts", "Me")
    var selectedScreen by remember { mutableStateOf(screens.first()) }

    Scaffold(
        bottomBar = {
            BottomNavigation {
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(getIconForScreen(screen), contentDescription = screen) },
                        label = { Text(screen) },
                        selected = screen == selectedScreen,
                        onClick = { selectedScreen = screen },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        },
        content = {
            when(selectedScreen){
                    "Dashboard" -> Dashboard()
                    "Me" -> MyAccount()
                    "Post" ,
                    "Alerts",
                    "Cart"-> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "You are @ $selectedScreen")
                        }
                    }
            }

        }
    )
}

@Composable
fun getIconForScreen(screen: String): ImageVector {
    return when (screen) {
        "Dashboard" -> Icons.Default.Home
        "Me" -> Icons.Default.AccountBox
        "Post" -> Icons.Default.Add
        "Alerts" -> Icons.Default.Notifications
        "Cart" -> Icons.Default.Shop
        else -> Icons.Default.Home
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavFramePreview() {
    MyCatelogTheme {
        BottomNavFrame("Home")
    }
}