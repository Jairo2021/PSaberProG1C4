package com.unicaldas.cursomoviles

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun onQuestion(botonQuestion: android.view.View) {
        val positiveButton = { dialog: DialogInterface, which: Int ->
            val intento = Intent(this, QuestionActivity::class.java)
            startActivity(intento)
        }

        val negativeButton = { _: DialogInterface, _:Int->}

        val dialog = AlertDialog.Builder(this)
            .setTitle("QUESTIONS!")
            .setPositiveButton("OK",positiveButton)
            .setNegativeButton("CANCEL",negativeButton)
//              .setNegativeButton(getResources().getString(R.string.txt_cancel),negativeButton)
        dialog.create()
        dialog.show()

        // Con Toast
        Toast.makeText(applicationContext,"QUESTION",Toast.LENGTH_LONG).show()
    }

    fun onEvaluation(botonEvaluation: android.view.View) {
        val positiveButton = { dialog: DialogInterface, which: Int ->
            val intento = Intent(this, EvaluationActivity::class.java)
            startActivity(intento)
        }

        val negativeButton = { _: DialogInterface, _:Int->}

        val dialog = AlertDialog.Builder(this)
            .setTitle("EVALUATION!")
            .setPositiveButton("OK",positiveButton)
            .setNegativeButton("CANCEL",negativeButton)
//              .setNegativeButton(getResources().getString(R.string.txt_cancel),negativeButton)
        dialog.create()
        dialog.show()

        // Con Toast
        Toast.makeText(applicationContext,"EVALUATION",Toast.LENGTH_LONG).show()
    }

    fun onLogic(botonLogic: android.view.View) {
        val positiveButton = { dialog: DialogInterface, which: Int ->
            val intento = Intent(this, LogicActivity::class.java)
            startActivity(intento)
        }

        val negativeButton = { _: DialogInterface, _:Int->}

        val dialog = AlertDialog.Builder(this)
            .setTitle("LOGIC ACTIVITIES!")
            .setPositiveButton("OK",positiveButton)
            .setNegativeButton("CANCEL",negativeButton)
//              .setNegativeButton(getResources().getString(R.string.txt_cancel),negativeButton)
        dialog.create()
        dialog.show()

        // Con Toast
        Toast.makeText(applicationContext,"LOGIC",Toast.LENGTH_LONG).show()
    }

    fun onUniversity(botonUniversity: android.view.View) {
        val positiveButton = { dialog: DialogInterface, which: Int ->
            val intento = Intent(this, UniversityActivity::class.java)
            startActivity(intento)
        }

        val negativeButton = { _: DialogInterface, _:Int->}

        val dialog = AlertDialog.Builder(this)
            .setTitle("UNIVERSITY INFORMATION!")
            .setPositiveButton("OK",positiveButton)
            .setNegativeButton("CANCEL",negativeButton)
//              .setNegativeButton(getResources().getString(R.string.txt_cancel),negativeButton)
        dialog.create()
        dialog.show()

        // Con Toast
        Toast.makeText(applicationContext,"UNIVERSITY",Toast.LENGTH_LONG).show()
    }


    fun onIntro(view: View) {
        Toast.makeText(this, "HELLO, WELCOME OPTIONS MENU", Toast.LENGTH_LONG).show()
    }
}