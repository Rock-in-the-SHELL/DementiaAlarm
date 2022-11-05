package com.example.dementiaalarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dementiaalarm.TestScreen.Companion.testScreen
import com.example.dementiaalarm.ui.theme.ComposeInitDispTheme
import com.example.dementiaalarm.ui.theme.DementiaAlarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            DementiaAlarmTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
            ComposeInitDisp()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun MainScreen(onClickButton: ()->Unit = {}) {
    Column {
        Text(text = "It is MainActivity now !!!")
        Button(onClick = onClickButton) {
            Text(text = "Go to TestScreen")
        }
    }
}

@Composable
fun ComposeInitDisp() {
    ComposeInitDispTheme {
        val navController = rememberNavController()
        MainNavHost(navController = navController, startDestination = "MainActivity")
    }
}

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination) {
        composable(route = "MainActivity") {
            MainScreen(onClickButton = { navController.navigate("TestScreen")})
        }
        composable(route = "TestScreen") {
            testScreen(onClickButton = { navController.navigateUp()})
        }
    }
}