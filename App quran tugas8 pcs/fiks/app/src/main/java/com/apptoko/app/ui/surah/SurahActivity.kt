package com.apptoko.app.ui.surah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apptoko.app.R

class SurahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah)
    }
    companion object {
        const val OPEN_SURAH = "open_surah"
    }
}