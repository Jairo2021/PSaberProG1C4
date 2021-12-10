package com.unicaldas.cursomoviles

/*
class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
    }
    fun onIntro(view: View) {
        Toast.makeText(this, "HOLA, VAMOS A CREAR PREGUNTAS", Toast.LENGTH_LONG).show()
    }
}*/
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_question.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var question: Question
    private lateinit var questionLiveData: LiveData<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        database = AppDatabase.getDatabase(this)

        val idQuestion = intent.getIntExtra("id", 0)

        questionLiveData = database.questions().get(idQuestion)

        questionLiveData.observe(this, Observer {
            question = it

        /*    question_question.text = question.question
            answer_question.text = question.answer
            option1_question.text = question.option1
            option2_question.text = question.option2
            option3_question.text = question.option3
            subject_question.text = question.subject*/
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.question_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.edit_item -> {
                val intent = Intent(this, NewQuestionActivity::class.java)
                intent.putExtra("question", question)
                startActivity(intent)
            }

            R.id.delete_item -> {
                questionLiveData.removeObservers(this)

                CoroutineScope(Dispatchers.IO).launch {
                    database.questions().delete(question)
                    this@QuestionActivity.finish()
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
