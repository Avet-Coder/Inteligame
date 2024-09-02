package com.example.mynewapp.UIDesign

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mynewapp.R
import com.example.mynewapp.ui.theme.ButtonColour
import com.example.mynewapp.ui.theme.GreenedWhite
import com.example.mynewapp.ui.theme.QuestBackColour
import com.example.mynewapp.ui.theme.ShadowColour
import com.example.mynewapp.ui.theme.TitleColour

@Composable
fun Gaming(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    navController: NavHostController
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
    val totalScore by remember {
        mutableStateOf(0)
    }
    val questScore by remember {
        mutableStateOf(0)
    }
    val questText by remember {
        mutableStateOf("Yerevan is the capital city of ...")
    }
    val isCorrect by remember {
        mutableStateOf(0)
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
                        .clickable { navController.navigate("register") }
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
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
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
                    .padding(bottom = 16.dp),
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
                text = stringResource(id = R.string.right_answer),
                style = textStyle,
                modifier = Modifier.fillMaxWidth(0.9f)
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
                        .height(160.dp)
                        .fillMaxWidth(0.95f)
                        .background(QuestBackColour)
                        .clip(RoundedCornerShape(size = 8.dp))
                        .padding(8.dp)
                        .verticalScroll(
                            rememberScrollState()
                        )
                )
            }
            Text(text = "answer", style = textStyle)
            Text(
                text = when (isCorrect) {
                    -1 -> stringResource(id = R.string.sorry_not_today)
                    1 -> stringResource(id = R.string.congratulation)
                    else -> stringResource(id = R.string.retry)
                }, style = textStyle,
                color = when (isCorrect) {
                    -1 -> Color.Red
                    1 -> GreenedWhite
                    else -> TitleColour
                }
            )
            Row {
                Button(
                    onClick = { /*TODO*/ },
                    Modifier
                        .width(150.dp)
                        .padding(12.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = ButtonColour)
                ) {

                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "okay")
                }
            }

        }
    }
}

@Preview
@Composable
private fun GamingPreview() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .size(24.dp)
    ) { innerPadding ->
        Gaming(innerPadding = innerPadding, navController = navController)
    }
}