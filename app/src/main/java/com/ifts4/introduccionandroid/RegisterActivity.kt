package com.ifts4.introduccionandroid

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.ifts4.introduccionandroid.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fondo animado
        val layout = findViewById<RelativeLayout>(R.id.registerLayout)
        val animationDrawable = layout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(1000)
        animationDrawable.setExitFadeDuration(2000)
        animationDrawable.start()

        // Spinner de ciudades
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.cities_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCities.adapter = adapter

        // Botón guardar
        binding.btnRegister.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            val lastName = binding.editTextLastName.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            val citySelected = binding.spinnerCities.selectedItem?.toString() ?: ""

            // Validación
            if (name.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completá todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (citySelected == "Seleccionar ciudad...") {
                Toast.makeText(this, "Seleccioná una ciudad válida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear objeto y guardar en SharedPreferences
            val person = Person(name = name, lastName = lastName, password = password, city = citySelected)
            val gson = Gson()
            val sharedPreferences = getSharedPreferences("appData", MODE_PRIVATE)
            sharedPreferences.edit().putString("person", gson.toJson(person)).apply()

            Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show()

            // Ir a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Botón salir
        binding.btnExit.setOnClickListener {
            finishAffinity() // Cierra la app
        }
    }
}

