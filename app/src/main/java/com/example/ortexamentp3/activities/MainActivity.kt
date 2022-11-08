package com.example.ortexamentp3.activities

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.ortexamentp3.R
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), DrawerController {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_home)

            // Busco y guardo la referencia a las vistas en variables
            drawerLayout = findViewById(R.id.drawer_layout)
            navigationView = findViewById(R.id.nav_view)
            navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
            setupDrawerLayout()
        }

        private fun setupDrawerLayout() {

            val navController = navHostFragment.navController
            // Vinculo la navegación del drawer con la del graph
            navigationView.setupWithNavController(navController)

            // Configuro la appbar para que muestre el icono del drawer y actualice el titulo
            NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

            // Listener para cuando se realiza la navegacion
            navController.addOnDestinationChangedListener { _, _, _ ->
                // Aca le digo que quiero que mi icono izquierdo de la appbar sea el del drawer
                supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)

            }
        }
        // Forzar el drawer a que se abra siempre
        override fun onSupportNavigateUp(): Boolean {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }

            return false
        }

       // override fun onCreateOptionsMenu(menu: Menu): Boolean {
         //   menuInflater.inflate(R.menu.basic_menu, menu)
        //    return true
      //  }
    companion object{
        private var currentUserId : Long? = null

           fun setCurrentUserId(userId : Long){
               if(currentUserId == null){
                   currentUserId = userId
               }
           }

           fun getCurrentUserId() : Long?{
               return currentUserId
           }

           fun endSession(){
               currentUserId = null
           }

    }

    override fun hideMenu() {
        supportActionBar?.hide()
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

    }

    override fun showMenu() {
        supportActionBar?.show()
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)

    }

    override fun hideHamburger() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun showHamburger() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


}


