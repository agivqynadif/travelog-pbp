package com.example.projecttravelog_pbp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.projecttravelog_pbp.ui.home.HomeFragment
import com.example.projecttravelog_pbp.ui.post.PostFragment
import com.example.projecttravelog_pbp.ui.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var splashContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        splashContainer = findViewById(R.id.fragmentContainerView)

        // Set the initial fragment or activity based on your requirements
        // For example, you can replace the splash screen fragment with the home fragment:
        replaceFragment(HomeFragment())

        // Hide the splash container
        splashContainer.visibility = View.GONE
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val selectedFragment: Fragment = when (item.itemId) {
            R.id.home -> HomeFragment()
            R.id.post -> PostFragment()
            R.id.profile -> ProfileFragment()
            // Add more cases for additional items in your bottom navigation
            else -> throw IllegalArgumentException("Invalid menu item ID")
        }

        replaceFragment(selectedFragment)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
