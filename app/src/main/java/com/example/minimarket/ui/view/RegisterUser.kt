package com.example.minimarket.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.minimarket.R
import com.example.minimarket.data.model.request.ClienteRequest
import com.example.minimarket.data.repository.ClienteRepository
import com.example.minimarket.databinding.ActivityRegisterUserBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterUser : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding
    private val clienteRepository = ClienteRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hide the action bar
        supportActionBar?.hide()
        enableEdgeToEdge()
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Text toolbar
        binding.customToolbar.setTitle(getString(R.string.strNewUser))

        // clean fields
        binding.textInputLayoutName.editText?.setText("")
        binding.textInputLayoutLastNameFather.editText?.setText("")
        binding.textInputLayoutLastNameMother.editText?.setText("")
        binding.textInputLayoutCellphone.editText?.setText("")
        binding.textInputLayoutEmail.editText?.setText("")
        binding.textInputLayoutPassword.editText?.setText("")

        val btnRegisterUser = findViewById<Button>(R.id.btnRegisterUser)
        btnRegisterUser.setOnClickListener {

            //Register
            val nombres = binding.textInputLayoutName.editText?.text.toString()
            val apellidoPaterno = binding.textInputLayoutLastNameFather.editText?.text.toString()
            val apellidoMaterno = binding.textInputLayoutLastNameMother.editText?.text.toString()
            val celular = binding.textInputLayoutCellphone.editText?.text.toString()
            val email = binding.textInputLayoutEmail.editText?.text.toString()
            val password = binding.textInputLayoutPassword.editText?.text.toString()

            if (nombres.isBlank()) {
                binding.textInputLayoutName.error = getString(R.string.strErrorEmpty)
                return@setOnClickListener
            } else {
                binding.textInputLayoutName.error = null
            }

            if (apellidoPaterno.isBlank()) {
                binding.textInputLayoutLastNameFather.error = getString(R.string.strErrorEmpty)
                return@setOnClickListener
            } else {
                binding.textInputLayoutLastNameFather.error = null
            }

            if (apellidoMaterno.isBlank()) {
                binding.textInputLayoutLastNameMother.error = getString(R.string.strErrorEmpty)
                return@setOnClickListener
            } else {
                binding.textInputLayoutLastNameMother.error = null
            }

            if (celular.isBlank()) {
                binding.textInputLayoutCellphone.error = getString(R.string.strErrorEmpty)
                return@setOnClickListener
            } else {
                binding.textInputLayoutCellphone.error = null
            }

            if (email.isBlank()) {
                binding.textInputLayoutEmail.error = getString(R.string.strErrorEmpty)
                return@setOnClickListener
            } else {
                binding.textInputLayoutEmail.error = null
            }

            if (password.isBlank()) {
                binding.textInputLayoutPassword.error = getString(R.string.strErrorEmpty)
                return@setOnClickListener
            } else {
                binding.textInputLayoutPassword.error = null
            }

            registerCustomer(nombres, apellidoPaterno, apellidoMaterno, celular, email, password)
        }
    }

    private fun registerCustomer(nombres: String, apellidoPaterno: String, apellidoMaterno: String, celular: String, email: String, password: String) {
        // Validate inputs
        if (nombres.isBlank() || apellidoPaterno.isBlank() || apellidoMaterno.isBlank() || celular.isBlank() || email.isBlank() || password.isBlank()) {
            Log.e("RegisterUser", "All fields must be filled")
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show()
            return
        }

        // Create ClienteRequest object
        val clienteRequest = ClienteRequest(
            idCliente = null,
            nombres = nombres,
            ape_paterno = apellidoPaterno,
            ape_materno = apellidoMaterno,
            celular = celular,
            email = email,
            password = password
        )

        // Register customer
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = clienteRepository.registrarCliente(clienteRequest)
                Log.d("RegisterUser", "Response: $response")
                withContext(Dispatchers.Main) {
                    if (response.email.isNotEmpty() && response.idCliente > 0) {
                        Log.i("RegisterUser", "Registration success")
                        Toast.makeText(this@RegisterUser, "Registro exitoso", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@RegisterUser, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Log.e("RegisterUser", "Registration failed")
                        Toast.makeText(this@RegisterUser, "Registro fallido", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.e("RegisterUser", "Error: ${e.message}")
                    Toast.makeText(this@RegisterUser, "Ocurrió un error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}