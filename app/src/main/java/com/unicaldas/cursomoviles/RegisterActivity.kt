package com.unicaldas.cursomoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun onIntro(view: View) {
        Toast.makeText(this, "HOLA, VAMOS A REGISTRAR UN USUARIO NUEVO", Toast.LENGTH_LONG).show()
    }
}