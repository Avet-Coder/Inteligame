package com.example.mynewapp.UIDesign

import android.app.AlertDialog
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mynewapp.R
import com.example.mynewapp.db.GamingDatabase
import com.example.mynewapp.ui.theme.ElectricBlue
import com.example.mynewapp.ui.theme.GreenedWhite
import com.example.mynewapp.ui.theme.GreeninGrey
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Registration(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    navController: NavHostController,
    database: GamingDatabase
) {

    var nameText by remember {
        mutableStateOf("")
    }
    var nickText by remember {
        mutableStateOf("")
    }
    var data by remember {
        mutableStateOf(listOf<String>())
    }
    runBlocking {
        data = database.dao.getAllUsers()

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
                        .clickable { navController.navigate("homePage") }
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
            Spacer(modifier = Modifier.padding(12.dp))


            LazyColumn(
                modifier = Modifier
                    .height(150.dp)
                    .padding(horizontal = 24.dp)
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
                                navController.navigate("gaming/${data[it]}")
                            },
                        lineHeight = 0.3.em,
                        letterSpacing = 0.15.em
                    )
                }
            }
            Text(
                text = stringResource(id = R.string.runAsAdmin),
                modifier = Modifier
                    .padding(top = 5.dp, end = 12.dp)
                    .clickable { navController.navigate("quizAdd") }
                    .fillMaxWidth(), textAlign = TextAlign.End, color = ElectricBlue
            )
            Spacer(modifier = Modifier.padding(6.dp))
            Text(
                text = stringResource(id = R.string.new_user),
                modifier = Modifier
                    .padding(top = 5.dp, end = 12.dp)
                    .clickable { navController.navigate("newUser") }
                    .fillMaxWidth(), textAlign = TextAlign.End, color = ElectricBlue
            )



            Spacer(modifier = Modifier.padding(32.dp))

        }
    }
}
//@Preview
//@Composable
//private fun RegistrationPrev() {
//    val navController = rememberNavController()
//    Scaffold(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//            .size(24.dp)
//    ) { innerPadding ->
//        Registration(innerPadding = innerPadding, navController = navController)
//    }
//}