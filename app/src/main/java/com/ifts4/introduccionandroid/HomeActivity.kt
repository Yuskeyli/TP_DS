package com.ifts4.introduccionandroid

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    private fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_burguer)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_bano -> showMessage("Baño seleccionado")
                R.id.nav_paseo -> showMessage("Paseo seleccionado")
                R.id.nav_guarderia -> showMessage("Guardería seleccionada")
                R.id.nav_logout -> logout()
            }
            drawerLayout.closeDrawers()
            true
        }

        // Agregar clicks a los servicios
        val servicio1 = findViewById<ImageView>(R.id.imgServicio1).parent as LinearLayout
        val servicio2 = findViewById<ImageView>(R.id.imgServicio2).parent as LinearLayout
        val servicio3 = findViewById<ImageView>(R.id.imgServicio3).parent as LinearLayout

        servicio1.setOnClickListener {
            showMessage("Baño seleccionado")
        }

        servicio2.setOnClickListener {
            showMessage("Paseo seleccionado")
        }

        servicio3.setOnClickListener {
            showMessage("Guardería seleccionada")
        }
    }

    // Crear el menú en la Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    // Manejar clicks del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(navigationView)
                true
            }
            R.id.nav_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
