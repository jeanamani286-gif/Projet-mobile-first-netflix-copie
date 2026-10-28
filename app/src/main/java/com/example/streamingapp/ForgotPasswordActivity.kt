package com.example.streamingapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val tvBackToLogin = findViewById<TextView>(R.id.tvBackToLogin)

        btnReset.setOnClickListener {
            val email = etEmail.text.toString().trim()
            if (email.isEmpty()) {
                Toast.makeText(this, "Veuillez entrer votre adresse e-mail", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Un lien de réinitialisation a été envoyé à $email", Toast.LENGTH_LONG).show()
                finish()
            }
        }

        tvBackToLogin.setOnClickListener {
            finish()
        }
    }
}
