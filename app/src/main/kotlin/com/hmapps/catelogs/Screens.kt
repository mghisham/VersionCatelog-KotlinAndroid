package com.hmapps.catelogs

sealed class Screens(val route : String) {
    object Dashboard : Screens("dashboard_route")
    object Post : Screens("post_route")
    object Me : Screens("me_route")
    object Alerts : Screens("alerts_route")
    object Cart : Screens("cart_route")
}