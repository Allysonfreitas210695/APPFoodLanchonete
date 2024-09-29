package com.example.appfoodlanchonetesanduche

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appfoodlanchonetesanduche.databinding.ActivityResumoBinding

class ResumoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResumoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumoBinding.inflate(layoutInflater)
        setContentView( binding.root )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.apply {
                setSystemBarsAppearance(
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
                window.statusBarColor = Color.TRANSPARENT
            }
        } else {
            // API 29 ou inferior
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            @Suppress("DEPRECATION")
            window.statusBarColor = Color.TRANSPARENT
        }


        binding.backMain.setOnClickListener {
            finish()
        }

        binding.btnReceita.setOnClickListener {
            val intent = Intent(this, ReceitaActivity::class.java)
            startActivity( intent )
        }
    }
}