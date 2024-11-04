package com.example.minimarket.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.minimarket.R
import com.example.minimarket.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Login: if is true, open the principal activity
        val emailInputLayout = binding.textInputLayoutEmail
        val passwordInputLayout = binding.textInputLayoutPassword

        emailInputLayout.setStartIconOnClickListener {
            emailInputLayout.editText?.setText("")
        }

        passwordInputLayout.setStartIconOnClickListener {
            passwordInputLayout.editText?.setText("")
        }

        binding.btnLogin.setOnClickListener {
            //Validate space in email
            if (binding.textInputLayoutEmail.editText?.text.toString().isEmpty()) {
                emailInputLayout.error = getString(R.string.strEmailFieldEmpty)
                return@setOnClickListener
            } else {
                emailInputLayout.error = null
            }

            //Validate space in password
            if (binding.textInputLayoutPassword.editText?.text.toString().isEmpty()) {
                passwordInputLayout.error = getString(R.string.strPasswordFieldEmpty)
                return@setOnClickListener
            } else {
                passwordInputLayout.error = null
            }

            //Validate username
            if (binding.textInputLayoutEmail.editText?.text.toString() == "admin") {
                emailInputLayout.error = null
            } else {
                emailInputLayout.error = getString(R.string.strEmailIncorrect)
                return@setOnClickListener
            }

            //Validate password
            if (binding.textInputLayoutPassword.editText?.text.toString() == "admin") {
                passwordInputLayout.error = null
            } else {
                passwordInputLayout.error = getString(R.string.strPasswordIncorrect)
                return@setOnClickListener
            }

            Log.i("LoginActivity", "Login success")
            val intent = android.content.Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }

        //Register: if is true, open the register user activity
        binding.btnRegister.setOnClickListener {
            val intent = android.content.Intent(this, RegisterUser::class.java)
            startActivity(intent)
        }

    }

    fun logMessages() {
        Log.d("ExampleTag", "This is a debug message")
        Log.i("ExampleTag", "This is an info message")
        Log.w("ExampleTag", "This is a warning message")
        Log.e("ExampleTag", "This is an error message")
    }
}