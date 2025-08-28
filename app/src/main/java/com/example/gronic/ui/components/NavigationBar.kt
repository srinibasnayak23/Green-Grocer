package com.example.gronic.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gronic.ui.navigation.NavItem

@Composable
fun NavigationBar(navController: NavHostController) {
    val currentDestination by navController.currentBackStackEntryAsState()

    NavigationBar {
        NavItem.items.forEach { item ->
            val selected = currentDestination?.destination?.route == item.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (item.route == NavItem.Home.route) {
                        navController.popBackStack(
                            NavItem.Home.route,
                            inclusive = false
                        )
                    } else {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}
