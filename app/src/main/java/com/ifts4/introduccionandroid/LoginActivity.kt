package com.ifts4.introduccionandroid

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextBreed: EditText
    private lateinit var checkboxRemember: CheckBox
    private lateinit var btnLogin: MaterialButton
    private lateinit var btnRegister: MaterialButton
    private lateinit var breedInputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Asignar referencias
        editTextName = findViewById(R.id.editTextName)
        editTextBreed = findViewById(R.id.editTextBreed)
        checkboxRemember = findViewById(R.id.checkboxRemember)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)
        breedInputLayout = findViewById(R.id.inputLayoutBreed)

        // Acción del botón Login
        btnLogin.setOnClickListener {
            val name = editTextName.text.toString()
            val breed = editTextBreed.text.toString()

            if (name.isNotBlank() && breed.isNotBlank()) {
                // Cambiar el color del hint de "Raza" a blanco
                breedInputLayout.defaultHintTextColor = getColorStateList(android.R.color.white)

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("NAME", name)
                intent.putExtra("BREED", breed)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción del botón Registro
        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}

