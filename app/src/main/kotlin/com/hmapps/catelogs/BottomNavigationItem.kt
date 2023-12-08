package com.hmapps.catelogs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: String = ""
) {
    fun bottomNavigationItems(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screens.Dashboard.route
            ),
            BottomNavigationItem(
                label = "Cart",
                icon = Icons.Filled.ShoppingCart,
                route = Screens.Cart.route
            ),
            BottomNavigationItem(
                label = "Post",
                icon = Icons.Filled.Add,
                route = Screens.Post.route
            ),
            BottomNavigationItem(
                label = "Alert",
                icon = Icons.Filled.Notifications,
                route = Screens.Alerts.route
            ),
            BottomNavigationItem(
                label = "Me",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Me.route
            ),
        )
    }
}