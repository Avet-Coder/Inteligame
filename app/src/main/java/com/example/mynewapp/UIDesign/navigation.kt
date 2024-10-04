package com.example.mynewapp.UIDesign

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mynewapp.db.GamingDatabase
@Composable
fun Navigation(
    navController: NavHostController,
    startDest: String,
    innerPadding: PaddingValues,
    database: GamingDatabase
) { NavHost(navController = navController, startDestination = startDest) {
        composable(startDest) {
            Starting(innerPadding = innerPadding, navController = navController)
        }
        composable("register") {
            Registration(
                innerPadding = innerPadding,
                navController = navController,
                database = database
            )
        }
        composable("gaming/{userName}") {backStackEntry->
            val userName = backStackEntry.arguments?.getString("userName")
            Gaming(innerPadding = innerPadding, navController = navController, database = database, userName = userName)
        }
        composable("quizAdd") {
            QuizAdd(innerPadding = innerPadding, navController = navController, database = database)
        }
        composable("newUser") {
            NewUserRegistration(
                innerPadding = innerPadding,
                navController = navController,
                database = database
            )
        }
    }

}