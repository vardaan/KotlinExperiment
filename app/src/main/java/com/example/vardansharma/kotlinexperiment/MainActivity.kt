package com.example.vardansharma.kotlinexperiment

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils.isEmpty
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener { v -> { loginClicked() } }
    }

    private fun loginClicked() {
        val emailText = email.text
        val passwordText = password.text

        when {
            isEmpty(emailText) -> toast("email empty")
            isEmpty(passwordText) -> toast("password empty")
            emailText.isValidEmail(emailText) -> toast("invalid email")
            else -> toast("login sucess")
        }
    }

    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    fun CharSequence.isValidEmail(target: CharSequence?): Boolean {
        when (target) {
            null -> return false
            else -> return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}
