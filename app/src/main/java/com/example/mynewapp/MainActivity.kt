package com.example.mynewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.mynewapp.UIDesign.Navigation
import com.example.mynewapp.db.GamingDatabase
import com.example.mynewapp.ui.theme.MyNewAppTheme

class MainActivity : ComponentActivity() {
    lateinit var db: GamingDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = GamingDatabase.getDatabase(this)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val startDest = "homePage"
            MyNewAppTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .size(24.dp)
                ) { innerPadding ->
                    Navigation(
                        navController = navController,
                        startDest = startDest,
                        innerPadding = innerPadding,
                        database = db
                    )
                }
            }
        }
    }
}
