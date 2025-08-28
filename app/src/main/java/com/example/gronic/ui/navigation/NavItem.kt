package com.example.gronic.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(val route: String, val label: String, val icon: ImageVector) {
    object Home : NavItem("home", "Home", Icons.Filled.Home)
    object Offers : NavItem("offers", "Offers", Icons.AutoMirrored.Filled.List)
    object Orders : NavItem("orders", "Orders", Icons.AutoMirrored.Default.Send)
    object Cart : NavItem("cart", "Cart", Icons.Filled.ShoppingCart)

    companion object {
        val items = listOf(Home, Offers, Cart, Orders)
    }
}
