package com.example.mynewapp.UIDesign

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mynewapp.R
import com.example.mynewapp.db.GamingDatabase
import com.example.mynewapp.db.Quiz
import com.example.mynewapp.ui.theme.GreenedWhite
import kotlinx.coroutines.runBlocking

@SuppressLint("MutableCollectionMutableState")
@Composable
fun QuizAdd(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    navController: NavHostController,
    database: GamingDatabase

) {
    val data = listOf(
        "area",
        "question",
        "score",
        "correct answer",
        "answer1",
        "answer2",
        "answer3",
        "answer4",
        "answer5",
        "answer6",
        "answer7",
        "answer8"
    )
    var area by remember { mutableStateOf("") }
    var question by remember { mutableStateOf("") }
    var score by remember { mutableStateOf("") }
    var correctAnswer by remember { mutableStateOf("") }
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    var answer3 by remember { mutableStateOf("") }
    var answer4 by remember { mutableStateOf("") }
    var answer5 by remember { mutableStateOf("") }
    var answer6 by remember { mutableStateOf("") }
    var answer7 by remember { mutableStateOf("") }
    var answer8 by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .size(24.dp)
    ) { innerPadding ->

        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(GreenedWhite)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Row(
                Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.aiga_left_arrow),
                    contentDescription = "",
                    modifier = Modifier
                        .width(48.dp)
                        .clickable { navController.navigate("register") }
                        .padding(12.dp)
                )


            }
            AnimatedVisibility(visible = true, enter = fadeIn(initialAlpha = 0.5f)) {


                Image(
                    painter = painterResource(id = R.drawable.landscape1),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                )
            }

            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = area,
                onValueChange = { area = it },
                singleLine = true,
                label = { Text(text = data[0]) },
                placeholder = { Text(text = data[0].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = question,
                onValueChange = { question = it },
                singleLine = true,
                label = { Text(text = data[1]) },
                placeholder = { Text(text = data[1].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = score,
                onValueChange = { score = it },
                singleLine = true,
                label = { Text(text = data[2]) },
                placeholder = { Text(text = data[2].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = correctAnswer,
                onValueChange = { correctAnswer = it },
                singleLine = true,
                label = { Text(text = data[3]) },
                placeholder = { Text(text = data[3].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = answer1,
                onValueChange = { answer1 = it },
                singleLine = true,
                label = { Text(text = data[4]) },
                placeholder = { Text(text = data[4].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = answer2,
                onValueChange = { answer2 = it },
                singleLine = true,
                label = { Text(text = data[5]) },
                placeholder = { Text(text = data[5].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = answer3,
                onValueChange = { answer3 = it },
                singleLine = true,
                label = { Text(text = data[6]) },
                placeholder = { Text(text = data[6].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = answer4,
                onValueChange = { answer4 = it },
                singleLine = true,
                label = { Text(text = data[7]) },
                placeholder = { Text(text = data[7].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = answer5,
                onValueChange = { answer5 = it },
                singleLine = true,
                label = { Text(text = data[8]) },
                placeholder = { Text(text = data[8].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = answer6,
                onValueChange = { answer6 = it },
                singleLine = true,
                label = { Text(text = data[9]) },
                placeholder = { Text(text = data[9].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = answer7,
                onValueChange = { answer7 = it },
                singleLine = true,
                label = { Text(text = data[10]) },
                placeholder = { Text(text = data[10].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = answer8,
                onValueChange = { answer8 = it },
                singleLine = true,
                label = { Text(text = data[11]) },
                placeholder = { Text(text = data[11].uppercase()) }
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Button(
                onClick = {
                    val newQuiz = Quiz(
                        area = area,
                        question = question,
                        score = score.toInt(),
                        correctAnswer = correctAnswer,
                        answer1 = answer1,
                        answer2 = answer2,
                        answer3 = answer3,
                        answer4 = answer4,
                        answer5 = answer5,
                        answer6 = answer6,
                        answer7 = answer7,
                        answer8 = answer8,
                    )
                    runBlocking {
                        database.dao.insertNewQuiz(newQuiz)
                    }
                }, modifier = Modifier
                    .width(196.dp)
                    .height(48.dp)
            ) {
                Text(text = stringResource(id = R.string.submit_db), fontSize = 18.sp)

            }


        }
    }

}
//
//@Preview
//@Composable
//private fun QuizAddPreview() {
//    val navController = rememberNavController()
//    Scaffold(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//            .size(24.dp)
//    ) { innerPadding ->
//        QuizAdd(innerPadding = innerPadding, navController = navController)
//    }
//}