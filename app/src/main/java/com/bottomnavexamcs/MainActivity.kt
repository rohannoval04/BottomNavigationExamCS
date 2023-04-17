package com.bottomnavexamcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bottomnavexamcs.Fragments.NotificationsFragment
import com.bottomnavexamcs.Fragments.SettingsFragment
import com.bottomnavexamcs.Fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFrag = HomeFragment()
        val notifFrag = NotificationsFragment()
        val settingsFrag = SettingsFragment()

        makeCurrentFragment(homeFrag)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.botNAv)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menuHome -> makeCurrentFragment(homeFrag)
                R.id.menuNotif -> makeCurrentFragment(notifFrag)
                R.id.menuSettings -> makeCurrentFragment(settingsFrag)

            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameNAV,fragment)
            commit()
        }
    }

}
