package com.jmancebo.pmpd_playground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        imageLion.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("@dev", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("@dev", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("@dev", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@dev", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@dev", "OnDestroy")
    }


}