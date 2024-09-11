package com.example.mynewapp.gameViewModel

//import androidx.lifecycle.ViewModel
//import com.example.mynewapp.db.Quiz
//import com.example.mynewapp.db.Repo
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//
//class GameViewModel(val repo: Repo): ViewModel() {
//    val _quizList = MutableStateFlow(emptyList<Quiz>())
//    val quizList = _quizList.asStateFlow()
//    fun insertQuiz(quiz: Quiz){
//        repo.insertNewQuize(quiz)
//    }
//}