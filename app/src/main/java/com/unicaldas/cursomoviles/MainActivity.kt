package com.unicaldas.cursomoviles

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var edtUsername: EditText? = null
    private var edtPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
    }

    fun onLogin(botonLogin: android.view.View) {
        if(edtUsername!!.text.toString() == "jairohramirezm@hotmail.com"){
            if(edtPassword!!.text.toString() == "1234"){
                //val intento = Intent(this, WelcomeActivity::class.java)
                //startActivity(intento)
                val positiveButton = {dialog: DialogInterface, which: Int ->
                    val intento = Intent(this, MenuActivity::class.java)
                    startActivity(intento)
                }

                val negativeButton = {_:DialogInterface,_:Int->}

                val dialog = AlertDialog.Builder(this)
                        .setTitle("WELCOME!")
                        .setMessage("User"+edtUsername!!.text.toString())
                        .setPositiveButton("OK",positiveButton)
                        .setNegativeButton("CANCEL",negativeButton)
//              .setNegativeButton(getResources().getString(R.string.txt_cancel),negativeButton)
                dialog.create()
                dialog.show()

                // Con Toast
                Toast.makeText(applicationContext,"WELCOME",Toast.LENGTH_LONG).show()
            }
            else{
                val dialog = AlertDialog.Builder(this).setTitle("ERROR")
                        .setMessage("Invalid username or password").create().show()
                //Con Toast
                Toast.makeText(this,"Invalid username or password",Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun onRegister(botonRegister: android.view.View) {
        val positiveButton = {dialog: DialogInterface, which: Int ->
            val intento = Intent(this, RegisterActivity::class.java)
            startActivity(intento)
        }

        val negativeButton = {_:DialogInterface,_:Int->}

        val dialog = AlertDialog.Builder(this)
            .setTitle("WELCOME!")
            .setPositiveButton("OK",positiveButton)
            .setNegativeButton("CANCEL",negativeButton)
//              .setNegativeButton(getResources().getString(R.string.txt_cancel),negativeButton)
        dialog.create()
        dialog.show()

        // Con Toast
        Toast.makeText(applicationContext,"WELCOME",Toast.LENGTH_LONG).show()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =when (item.itemId){
        R.id.action_search -> {
            Toast.makeText(this, R.string.txt_action_search,Toast.LENGTH_SHORT).show()
            true
        }
        R.id.action_settings -> {
            Toast.makeText(this, R.string.txt_action_settings,Toast.LENGTH_SHORT).show()
            true
        }
        R.id.action_logout -> {
            Toast.makeText(this, R.string.txt_action_logout,Toast.LENGTH_SHORT).show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }

    }
}