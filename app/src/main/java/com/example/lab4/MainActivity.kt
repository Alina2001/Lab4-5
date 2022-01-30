package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lab4.event_list.EventsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val eventsFragment = EventsFragment()
    private val holidayFragment = HolidaysFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.events_item -> { replaceFragment(eventsFragment) }
                R.id.holidays_item -> { replaceFragment(holidayFragment) }
                R.id.profile_item -> { replaceFragment(profileFragment) }
            }
            true
        }
        bottomNavView.selectedItemId = R.id.events_item

    }

    private fun replaceFragment(selectedFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragment_container_view, selectedFragment)
            .commit()
    }
}