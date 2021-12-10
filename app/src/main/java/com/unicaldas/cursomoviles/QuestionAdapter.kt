package com.unicaldas.cursomoviles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_question.view.*
import kotlinx.android.synthetic.main.item_question.view.*

class QuestionAdapter(private val mContext: Context, private val listQuestions: List<Question>) : ArrayAdapter<Question>(mContext, 0, listQuestions) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_question, parent, false)

        val qtn = listQuestions[position]

    /*    layout.edtQuestion.text = qtn.question
        layout.edtAnswer.text = qtn.answer
        layout.edtOption1.text = qtn.option1
        layout.edtOption2.text = qtn.option2
        layout.edtOption3.text = qtn.option3
        layout.edtSubject.text = qtn.subject*/


        return layout
    }

}