package com.example.mynewapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserTable(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val userName:String,
    val password:String,
    val score:Int = 0
)
@Entity
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val area:String,
    val question:String,
    val score: Int,
    val correctAnswer:String,
    val answer1:String,
    val answer2:String,
    val answer3:String,
    val answer4:String,
    val answer5:String,
    val answer6:String,
    val answer7:String,
    val answer8:String,
)