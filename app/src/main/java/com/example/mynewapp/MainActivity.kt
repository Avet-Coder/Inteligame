package com.example.mynewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.room.Dao
import androidx.room.Room
import com.example.mynewapp.UIDesign.Navigation
import com.example.mynewapp.db.GameAccessDao
import com.example.mynewapp.db.GamingDatabase
import com.example.mynewapp.db.Repo
import com.example.mynewapp.gameViewModel.GameViewModel
import com.example.mynewapp.ui.theme.MyNewAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            context = applicationContext,
            klass = GamingDatabase::class.java,
            name = "gamingDatabase.db"
        ).build()
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
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}
