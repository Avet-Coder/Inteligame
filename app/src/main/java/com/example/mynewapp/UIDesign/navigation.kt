package com.example.mynewapp.UIDesign

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import java.security.AccessController

@Composable
fun Navigation(navController: NavHostController, startDest: String, innerPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = startDest) {
        composable(startDest) {
            Starting(innerPadding = innerPadding,navController = navController)
        }
        composable("register") {
            Registration(innerPadding = innerPadding, navController = navController)
        }
        composable("gaming") {
            Gaming(innerPadding = innerPadding, navController = navController)
        }
        composable("quizAdd") {
            QuizAdd(innerPadding = innerPadding, navController = navController)
        }

    }

}