package com.example.bottomprogress

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, DashboardFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, NotifFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
    override fun onStartProgressBar() {

        progressBar.visibility = View.VISIBLE
    }

    override fun onStopProgressBar() {
        progressBar.visibility = View.GONE
    }
}
