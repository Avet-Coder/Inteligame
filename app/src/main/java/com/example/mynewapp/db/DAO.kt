package com.example.mynewapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameAccessDao{
//    @Query("SELECT * FROM UserTable")
//    suspend fun getAllRows():List<UserTable>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewQuiz(quiz: Quiz)
//    @Query("SELECT * FROM Quiz")
//    suspend fun getAllQuiz():List<Quiz>
    @Query("SELECT area FROM Quiz")
    suspend fun getAllQuizArea():List<String>
    @Query("SELECT * FROM Quiz WHERE area = :area")
    suspend fun getAllAreaQuiz(area:String):List<Quiz>
}