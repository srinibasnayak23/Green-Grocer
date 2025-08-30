package com.example.gronic

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gronic.data.local.Prefs
import com.example.gronic.data.remote.RetrofitClient
import com.example.gronic.ui.screens.MainScreen
import com.example.gronic.ui.screens.auth.LoginScreen
import com.example.gronic.ui.screens.auth.SignUpScreen
import com.example.gronic.ui.theme.GronicTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
                    // 🔹 LOGIN
                    composable("login") {
                        LoginScreen(
                            navController = navController,
                            onLoginClick = { email, password ->
                                CoroutineScope(Dispatchers.IO).launch {
                                    try {
                                        val response = RetrofitClient.api.login(
                                            username = email,
                                            password = password
                                        )
                                        withContext(Dispatchers.Main) {
                                            if (response.isSuccessful && response.body()?.status == 200) {
                                                val user = response.body()?.data
                                                prefs.saveUser(
                                                    email,
                                                    user?.FirstName,
                                                    user?.EmployeeId
                                                )
                                                navController.navigate("main") {
                                                    popUpTo("login") { inclusive = true }
                                                }
                                            } else {
                                                Toast.makeText(
                                                    this@MainActivity,
                                                    response.body()?.message ?: "Login failed",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    } catch (e: Exception) {
                                        withContext(Dispatchers.Main) {
                                            Toast.makeText(
                                                this@MainActivity,
                                                "Error: ${e.message}",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }
                                }
                            }
                        )
                    }

                    // 🔹 SIGN UP (dummy, still saving user)
                    composable("signup") {
                        SignUpScreen(
                            navController = navController,
                            onSignUpClick = { name, email, password ->
                                prefs.saveUser(email, name)
                                navController.navigate("main") {
                                    popUpTo("login") { inclusive = true }
                                }
                            }
                        )
                    }

                    // 🔹 MAIN SCREEN
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
