package com.unicaldas.cursomoviles

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuestionsDao {
    @Query("SELECT * FROM questions")
    fun getAll(): LiveData<List<Question>>

    @Query("SELECT * FROM questions WHERE idQuestion = :id")
    fun get(id: Int): LiveData<Question>

    @Insert
    fun insertAll(vararg questions: Question)

    @Update
    fun update(question: Question)

    @Delete
    fun delete(question: Question)
}