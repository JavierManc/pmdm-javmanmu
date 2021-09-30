package com.jmancebo.pmpd_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageLion : AppCompatImageView = findViewById(R.id.image_lion)
        //val imageLion = findViewById<AppCompatImageView>(R.id.image_lion)

        //imageLion.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.lion))
        imageLion.setImageResource(R.drawable.lion)

    }
}