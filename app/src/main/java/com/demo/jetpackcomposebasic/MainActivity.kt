package com.demo.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.demo.jetpackcomposebasic.navigation.Destination
import com.demo.jetpackcomposebasic.navigation.NavigationHost
import com.demo.jetpackcomposebasic.presentation.components.BottomNavigationBar
import com.demo.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    val navigationItems = listOf(
        Destination.Screen1,
        Destination.Screen2,
        Destination.Screen3
    )

    Scaffold(bottomBar = {
        BottomNavigationBar(navController = navController, items = navigationItems)
    }) {
        NavigationHost(navController = navController)
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicTheme {
        MainScreen()
    }
}