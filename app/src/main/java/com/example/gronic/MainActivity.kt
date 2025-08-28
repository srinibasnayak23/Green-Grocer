package com.example.gronic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gronic.data.local.Prefs
import com.example.gronic.ui.screens.MainScreen
import com.example.gronic.ui.screens.auth.LoginScreen
import com.example.gronic.ui.screens.auth.SignUpScreen
import com.example.gronic.ui.theme.GronicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val prefs = Prefs(this)
        val savedUser = prefs.getUser()

        setContent {
            GronicTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = if (savedUser == null) "login" else "main"
                ) {
                    composable("login") {
                        LoginScreen(
                            navController = navController,
                            onLoginClick = { email, password ->
                                if (email == "test@gmail.com" && password == "12345") {
                                    prefs.saveUser(email)
                                    navController.navigate("main") {
                                        popUpTo("login") { inclusive = true }
                                    }
                                }
                            }
                        )
                    }

                    composable("signup") {
                        SignUpScreen(
                            navController = navController,
                            onSignUpClick = { name, email, password ->
                                prefs.saveUser(email) // ✅ Save new user
                                navController.navigate("main") {
                                    popUpTo("login") { inclusive = true }
                                }
                            }
                        )
                    }

                    composable("main") {
                        MainScreen(
                            onLogout = {
                                prefs.clearUser()
                                navController.navigate("login") {
                                    popUpTo("main") { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
