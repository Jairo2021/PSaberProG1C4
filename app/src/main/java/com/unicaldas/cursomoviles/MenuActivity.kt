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


    fun onIntro(view: View) {
        Toast.makeText(this, "HOLA, BIENVENIDO AL MENU DE OPCIONES", Toast.LENGTH_LONG).show()
    }
}