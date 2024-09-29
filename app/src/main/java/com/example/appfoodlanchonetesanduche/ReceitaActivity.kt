package com.example.appfoodlanchonetesanduche

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appfoodlanchonetesanduche.databinding.ActivityReceitaBinding

class ReceitaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReceitaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceitaBinding.inflate( layoutInflater )
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

        binding.btnBackResumo.setOnClickListener {
            finish()
        }
    }
}