package com.example.mynewapp.UIDesign

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mynewapp.R
import com.example.mynewapp.db.GamingDatabase
import com.example.mynewapp.db.Quiz
import com.example.mynewapp.db.UserTable
import com.example.mynewapp.ui.theme.Answer1
import com.example.mynewapp.ui.theme.Answer2
import com.example.mynewapp.ui.theme.Answer3
import com.example.mynewapp.ui.theme.Answer4
import com.example.mynewapp.ui.theme.ButtonColour
import com.example.mynewapp.ui.theme.DarkGreen
import com.example.mynewapp.ui.theme.GreenedWhite
import com.example.mynewapp.ui.theme.GreeninGrey
import com.example.mynewapp.ui.theme.QuestBackColour
import com.example.mynewapp.ui.theme.ShadowColour
import com.example.mynewapp.ui.theme.TitleColour
import kotlinx.coroutines.runBlocking

@SuppressLint("MutableCollectionMutableState")
@Composable
fun Gaming(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    navController: NavHostController,
    database: GamingDatabase,
    userName: String? = null
) {
    val titleStyle = TextStyle(
        fontSize = 24.sp,
        color = TitleColour,
        fontWeight = FontWeight.W800,
        shadow = Shadow(color = ShadowColour, offset = Offset(10.0f, 15.0f), blurRadius = 3.1f),
        letterSpacing = 0.1.em
    )
    val textStyle = TextStyle(
        fontSize = 18.sp,
        color = TitleColour,
        fontWeight = FontWeight.W400
    )
    val smallTextStyle = TextStyle(
        fontSize = 15.sp,
        color = TitleColour,
        fontWeight = FontWeight.Medium
    )
    var correctAnswer by remember {
        mutableStateOf("")
    }
    var data by remember {
        mutableStateOf(listOf<String>())
    }
    val answerList by remember {
        mutableStateOf(arrayListOf<String>())
    }
    val dataRandom by remember {
        mutableStateOf(arrayListOf<Quiz>())
    }
    val userList by remember {
        mutableStateOf(arrayListOf<UserTable>())
    }
    var totalScore by remember {
        mutableStateOf(0)
    }
    var questScore by remember {
        mutableStateOf(0)
    }
    var questText by remember {
        mutableStateOf("Yerevan is the capital city of ...")
    }
    var isCorrect by remember {
        mutableStateOf(0)
    }
    runBlocking {
        data = database.dao.getAllQuizArea().toSet().toList()
        if (userName != null) userList.add(database.dao.getUser(userName))
        totalScore = userList[0].score
    }

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
                .background(GreenedWhite),
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
                        .clickable {
                            runBlocking {
                                if (userName != null) database.dao.updateUserScore(
                                    userName = userName,
                                    score = totalScore
                                )
                            }
                            navController.navigate("register")
                        }
                        .padding(12.dp)
                )

            }
            Text(
                text = stringResource(id = R.string.gaming_start),
                textAlign = TextAlign.Center,
                style = titleStyle
            )
            Row(
                Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = userName ?: "",
                    style = smallTextStyle,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Text(
                    text = stringResource(id = R.string.total_score),
                    style = smallTextStyle,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Text(text = totalScore.toString(), style = smallTextStyle)
            }
            Row(
                Modifier
                    .fillMaxWidth(0.9f)
                    .padding(bottom = 4.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(id = R.string.quest_score),
                    style = smallTextStyle,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Text(text = questScore.toString(), style = smallTextStyle)
            }

            Text(
                text = stringResource(id = R.string.choose_tip),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {


                LazyColumn(
                    modifier = Modifier
                        .height(72.dp)
                        .background(GreeninGrey)
                        .border(
                            border = ButtonDefaults.outlinedButtonBorder,
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(horizontal = 12.dp)
                ) {
                    items(data.size) {
                        Text(
                            text = data[it],
                            fontSize = 18.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(28.dp)
                                .padding(start = 24.dp)
                                .clickable {
                                    answerList.clear()
                                    dataRandom.clear()
                                    runBlocking {
                                        dataRandom += database.dao
                                            .getAllAreaQuiz(data[it])
                                            .random()
                                    }
                                    questText = dataRandom[0].question
                                    questScore = dataRandom[0].score
                                    correctAnswer = dataRandom[0].correctAnswer
                                    answerList += correctAnswer
                                    val index = arrayListOf(
                                        dataRandom[0].answer1,
                                        dataRandom[0].answer2,
                                        dataRandom[0].answer3,
                                        dataRandom[0].answer4,
                                        dataRandom[0].answer5,
                                        dataRandom[0].answer6,
                                        dataRandom[0].answer7,
                                        dataRandom[0].answer8
                                    )
                                    answerList += index.removeAt((0..7).random())
                                    answerList += index.removeAt((0..6).random())
                                    answerList += index.removeAt((0..5).random())
                                    answerList.shuffle()
                                    dataRandom.clear()
                                },
                            lineHeight = 0.3.em,
                            letterSpacing = 0.15.em
                        )
                    }
                }
            }
            Text(
                text = stringResource(id = R.string.right_answer),
                style = textStyle,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 12.dp)
            )
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 6.dp))
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = questText,
                    style = textStyle,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth(0.9f)
                        .background(QuestBackColour)
                        .clip(RoundedCornerShape(size = 8.dp))
                        .padding(8.dp)
                        .verticalScroll(
                            rememberScrollState()
                        )
                )
            }
            Text(
                text = if (answerList.isEmpty()) "" else answerList[0],
                style = textStyle,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(top = 12.dp)
                    .height(30.dp)
                    .background(Answer1)
                    .clickable {
                        if (answerList.isNotEmpty() && correctAnswer == answerList[0]) {
                            totalScore += questScore
                            isCorrect = 1
                            answerList.clear()
                        } else if (answerList.isNotEmpty() && correctAnswer != answerList[0]) {
                            isCorrect = -1
                            answerList.clear()
                        }
                    }
            )
            Text(
                text = if (answerList.isEmpty()) "" else answerList[1],
                style = textStyle,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(top = 6.dp)
                    .height(30.dp)
                    .background(Answer2)
                    .clickable {
                        if (answerList.isNotEmpty() && correctAnswer == answerList[1]) {
                            totalScore += questScore
                            isCorrect = 1
                            answerList.clear()
                        } else if (answerList.isNotEmpty() && correctAnswer != answerList[1]) {
                            isCorrect = -1
                            answerList.clear()
                        }
                    }
            )
            Text(
                text = if (answerList.isEmpty()) "" else answerList[2],
                style = textStyle,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(top = 6.dp)
                    .height(30.dp)
                    .background(Answer3)
                    .clickable {
                        if (answerList.isNotEmpty() && correctAnswer == answerList[2]) {
                            totalScore += questScore
                            isCorrect = 1
                            answerList.clear()
                        } else if (answerList.isNotEmpty() && correctAnswer != answerList[2]) {
                            isCorrect = -1
                            answerList.clear()
                        }
                    }
            )
            Text(
                text = if (answerList.isEmpty()) "" else answerList[3],
                style = textStyle,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(top = 6.dp, bottom = 6.dp)
                    .height(30.dp)
                    .background(Answer4)
                    .clickable {
                        if (answerList.isNotEmpty() && correctAnswer == answerList[3]) {
                            totalScore += questScore
                            isCorrect = 1
                            answerList.clear()
                        } else if (answerList.isNotEmpty() && correctAnswer != answerList[3]) {
                            isCorrect = -1
                            answerList.clear()
                        }
                    }
            )
            Text(text = "answer", style = textStyle)
            Text(
                text = when (isCorrect) {
                    -1 -> stringResource(id = R.string.sorry_not_today)
                    1 -> stringResource(id = R.string.congratulation)
                    else -> stringResource(id = R.string.retry)
                }, style = textStyle,
                color = when (isCorrect) {
                    -1 -> Color.Red
                    1 -> DarkGreen
                    else -> TitleColour
                }
            )
            Row {
                Button(
                    onClick = { },
                    Modifier
                        .width(150.dp)
                        .padding(12.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = ButtonColour)
                ) {

                }
                Button(
                    onClick = { },
                    Modifier
                        .width(150.dp)
                        .padding(12.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = ButtonColour)
                ) {

                }
            }

        }
    }
}

//@Preview
//@Composable
//private fun GamingPreview() {
//    val navController = rememberNavController()
//    Scaffold(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//            .size(24.dp)
//    ) { innerPadding ->
//        Gaming(innerPadding = innerPadding, navController = navController)
//    }
//}