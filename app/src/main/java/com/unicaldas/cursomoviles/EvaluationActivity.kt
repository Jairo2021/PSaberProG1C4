package com.unicaldas.cursomoviles

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class EvaluationActivity : AppCompatActivity() {
    private val ids_answers = intArrayOf(
        R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    )
    private var correct_answer = 0
    private var current_question = 0
    private lateinit var all_questions: Array<String>
    private lateinit var answer_is_correct: BooleanArray
    private lateinit var answer: IntArray
    private var text_question: TextView? = null
    private var group: RadioGroup? = null
    private var btn_next: Button? = null
    private var btn_prev: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluation)
        text_question = findViewById(R.id.text_question) as TextView?
        group = findViewById(R.id.answer_group) as RadioGroup?
        btn_next = findViewById(R.id.btn_check) as Button?
        btn_prev = findViewById(R.id.btn_prev) as Button?
        all_questions = resources.getStringArray(R.array.all_questions)
        answer_is_correct = BooleanArray(all_questions.size)
        answer = IntArray(all_questions.size)
        for (i in answer.indices) {
            answer[i] = -1
        }
        current_question = 0
        showQuestion()
        btn_next!!.setOnClickListener {
            checkAnswer()
            if (current_question < all_questions.size - 1) {
                current_question++
                showQuestion()
            } else {
                var correctas = 0
                var incorrectas = 0
                for (b in answer_is_correct) {
                    if (b) correctas++ else incorrectas++
                }
                val resultado = String.format(
                    Locale.getDefault(),
                    "Correctas: %d -- Incorrectas: %d",
                    correctas,
                    incorrectas
                )
                Toast.makeText(this@EvaluationActivity, resultado, Toast.LENGTH_LONG).show()
                finish()
            }
        }
        btn_prev!!.setOnClickListener {
            checkAnswer()
            if (current_question > 0) {
                current_question--
                showQuestion()
            }
        }
    }

    private fun checkAnswer() {
        val id = group!!.checkedRadioButtonId
        var ans = -1
        for (i in ids_answers.indices) {
            if (ids_answers[i] == id) {
                ans = i
            }
        }
        answer_is_correct[current_question] = ans == correct_answer
        answer[current_question] = ans
    }

    private fun showQuestion() {
        val q = all_questions[current_question]
        val parts = q.split(";").toTypedArray()
        group!!.clearCheck()
        text_question!!.text = parts[0]
        for (i in ids_answers.indices) {
            val rb = findViewById(ids_answers[i]) as RadioButton
            var ans = parts[i + 1]
            if (ans[0] == '*') {
                correct_answer = i
                ans = ans.substring(1)
            }
            rb.text = ans
            if (answer[current_question] == i) {
                rb.isChecked = true
            }
        }
        if (current_question == 0) {
            btn_prev!!.visibility = View.GONE
        } else {
            btn_prev!!.visibility = View.VISIBLE
        }
        if (current_question == all_questions.size - 1) {
            btn_next!!.setText(R.string.finish)
        } else {
            btn_next!!.setText(R.string.next)
        }
    }
}