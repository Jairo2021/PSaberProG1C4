package com.unicaldas.cursomoviles

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "questions")
class Question(
    val question:String,
    val answer: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val subject: String,
    @PrimaryKey(autoGenerate = true)
    var idQuestion: Int = 0
) : Serializable