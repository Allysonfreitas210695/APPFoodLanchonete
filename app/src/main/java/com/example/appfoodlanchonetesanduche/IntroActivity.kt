package com.example.appfoodlanchonetesanduche

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appfoodlanchonetesanduche.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
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

        binding.progressBar.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            binding.progressBar.visibility = View.GONE
            val intent = Intent(this@IntroActivity, MainActivity::class.java)
            startActivity(intent)
        }, 5000)
    }
}