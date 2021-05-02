package com.krishnanand.navigationcomponeent

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val toolbar: Toolbar by lazy {
        findViewById(R.id.toolbar)
    }

    lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as  NavHostFragment
        navController = navHostFragment.findNavController()
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.mainFragment, R.id.searchFragment)
        )
        setSupportActionBar(toolbar)
        with(navController) {
            setupActionBarWithNavController(this, appBarConfiguration)
            bottom_nav.setupWithNavController(this)
        }
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp() || super.onSupportNavigateUp()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
         when(item.itemId) {
            R.id.termsAndConditions -> {
                with(NavGraphDirections.actionGlobalTermsAndConditionsFragment()) {
                    navController.navigate(this)
                }
                true
            }
            else ->  item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
         }
}