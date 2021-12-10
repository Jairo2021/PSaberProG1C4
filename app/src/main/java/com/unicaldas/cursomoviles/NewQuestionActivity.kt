package com.unicaldas.cursomoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_question.*
import kotlinx.android.synthetic.main.activity_question.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_question)

        var idQuestion: Int? = null

        if (intent.hasExtra("question")) {
            val question = intent.extras?.getSerializable("question") as Question

            edtQuestion.setText(question.question)
            edtAnswer.setText(question.answer)
            edtOption1.setText(question.option1)
            edtOption2.setText(question.option2)
            edtOption3.setText(question.option3)
            edtSubject.setText(question.subject)
            idQuestion = question.idQuestion
        }

        val database = AppDatabase.getDatabase(this)

        btnQuestion.setOnClickListener {
            val ques = edtQuestion.text.toString()
            val answer = edtAnswer.text.toString()
            val option1 = edtOption1.text.toString()
            val option2 = edtOption2.text.toString()
            val option3 = edtOption3.text.toString()
            val subject = edtSubject.text.toString()

            val question = Question(ques, answer, option1, option2, option3, subject, R.drawable.ic_launcher_background)

            if (idQuestion != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    question.idQuestion = idQuestion

                    database.questions().update(question)

                    this@NewQuestionActivity.finish()
                }
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    database.questions().insertAll(question)

                    this@NewQuestionActivity.finish()
                }
            }
        }
    }
}