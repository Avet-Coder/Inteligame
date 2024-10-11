package com.example.mynewapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface GameAccessDao {
    @Query("SELECT userName  FROM UserTable")
    suspend fun getAllUsers(): List<String>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewQuiz(quiz: Quiz)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewUser(userTable: UserTable)
    @Query("UPDATE userTable SET score = :score WHERE userName =:userName ")
    suspend fun updateUserScore(userName:String,score: Int)

    @Query("SELECT area FROM Quiz")
    suspend fun getAllQuizArea(): List<String>

    @Query("SELECT * FROM Quiz WHERE area = :area")
    suspend fun getAllAreaQuiz(area: String): List<Quiz>

    @Query("SELECT * FROM UserTable WHERE userName = :name")
    suspend fun getUser(name: String): UserTable

    @Query("DELETE  FROM UserTable WHERE userName = :name")
    suspend fun deleteUser(name: String)
}