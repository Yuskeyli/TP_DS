package com.ifts4.introduccionandroid

import android.content.Context
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

        // Referencias de la vista
        editTextName = findViewById(R.id.editTextName)
        editTextBreed = findViewById(R.id.editTextBreed)
        checkboxRemember = findViewById(R.id.checkboxRemember)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)
        breedInputLayout = findViewById(R.id.inputLayoutBreed)

        val sharedPref = getSharedPreferences("MisDatos", Context.MODE_PRIVATE)

        // Cargar datos guardados si el usuario tildó 'Recordar datos'
        val nameGuardado = sharedPref.getString("NOMBRE", "")
        val razaGuardada = sharedPref.getString("RAZA", "")
        val recordar = sharedPref.getBoolean("RECORDAR", false)

        if (recordar) {
            editTextName.setText(nameGuardado)
            editTextBreed.setText(razaGuardada)
            checkboxRemember.isChecked = true
        }

        btnLogin.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val breed = editTextBreed.text.toString().trim()

            if (name.isEmpty()) {
                editTextName.error = "Ingrese su Nombre"
                editTextName.requestFocus()
                return@setOnClickListener
            }

            if (breed.isEmpty()) {
                editTextBreed.error = "Ingrese la raza"
                editTextBreed.requestFocus()
                return@setOnClickListener
            }

            // Guardar o limpiar según el estado del checkbox
            if (checkboxRemember.isChecked) {
                with(sharedPref.edit()) {
                    putString("NOMBRE", name)
                    putString("RAZA", breed)
                    putBoolean("RECORDAR", true)
                    apply()
                }
            } else {
                with(sharedPref.edit()) {
                    clear()
                    apply()
                }
            }

            // Cambiar el color del hint de "Raza" a blanco
            breedInputLayout.defaultHintTextColor = getColorStateList(android.R.color.white)

            // Ir al Home
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("NAME", name)
            intent.putExtra("BREED", breed)
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
