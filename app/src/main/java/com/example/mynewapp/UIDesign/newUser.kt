package com.example.mynewapp.UIDesign


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mynewapp.R
import com.example.mynewapp.db.GamingDatabase
import com.example.mynewapp.db.UserTable
import com.example.mynewapp.ui.theme.GreenedWhite
import kotlinx.coroutines.runBlocking

@Composable
fun NewUserRegistration(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    navController: NavHostController,
    database: GamingDatabase
) {
    var data by remember {
        mutableStateOf(listOf<String>())
    }
    var nameText by remember {
        mutableStateOf("")
    }
    var nickText by remember {
        mutableStateOf("")
    }
    var isAlert by remember {
        mutableStateOf(false)
    }
    if (isAlert) Alert()
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
            OutlinedTextField(
                value = nameText,
                onValueChange = { nameText = it },
                singleLine = true,
                label = { Text(text = "name") },
                placeholder = { Text(text = "Name") }
            )
            Spacer(modifier = Modifier.padding(12.dp))
            OutlinedTextField(
                value = nickText,
                onValueChange = { nickText = it },
                singleLine = true,
                label = { Text(text = "nickname") },
                placeholder = { Text(text = "Nickname") }
            )

            Spacer(modifier = Modifier.padding(32.dp))




            Spacer(modifier = Modifier.padding(32.dp))
            Button(
                onClick = {

                    runBlocking {
                        data = database.dao.getAllUsers()
                    }
                    if (nameText in data){
isAlert = true

                    }else{isAlert = false
                    val newUser = UserTable(userName = nameText, password = nickText)
                    runBlocking {
                        if (nameText.isNotEmpty() && nickText.isNotEmpty()) database.dao.insertNewUser(
                            newUser
                        )
                    }
                    nameText = ""
                    nickText = ""
                    navController.navigate("register")
                    }
                }, modifier = Modifier
                    .width(196.dp)
                    .height(48.dp)
            ) {
                Text(text = stringResource(id = R.string.submit), fontSize = 18.sp)

            }

        }
    }
}

@Composable
fun Alert(modifier: Modifier = Modifier) {
    var showDialog by remember {
        mutableStateOf(true)
    }
    if (showDialog){
    AlertDialog(onDismissRequest = {showDialog = false},
        dismissButton = {
        }, confirmButton = {
            TextButton(onClick = { showDialog = false
            }) {
                Text(text = stringResource(id = R.string.okay))
            }
        },
        icon = {},
        text = {
            Text(
                text = stringResource(id = R.string.alert_text_username),
                textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth()
            )
        }
    )
}}
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