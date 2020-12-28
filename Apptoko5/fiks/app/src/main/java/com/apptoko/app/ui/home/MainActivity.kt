package com.apptoko.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.apptoko.app.R
import com.apptoko.app.databinding.ActivityMainBinding
import com.apptoko.app.ui.auth.ApptokoAuth
import com.apptoko.app.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
       binding.bottomNav.setOnNavigationItemSelectedListener {
           when(it.itemId) {
               R.id.ic_home -> navigate(R.id.homeFragment)
               R.id.ic_surah -> navigate(R.id.surahFragment)
               R.id.ic_favorite -> navigate(R.id.favoriteFragment2)
               R.id.ic_profile -> navigate(R.id.profileFragment3)
               else -> false
           }
       }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true

    }
}
