package com.example.mynewapp.db

import androidx.compose.ui.graphics.Outline
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GameAccessDao{
    @Query("SELECT * FROM UserTable")
    fun getAllRows():Flow<List<UserTable>>
    @Insert
    fun insertNewQuize(quiz: Quiz)
}