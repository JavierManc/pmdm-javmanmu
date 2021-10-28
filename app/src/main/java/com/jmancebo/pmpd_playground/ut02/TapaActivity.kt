package com.jmancebo.pmpd_playground.ut02

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.appcompat.widget.AppCompatTextView
import com.jmancebo.pmpd_playground.R

class TapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_justeat_conslayout)
        setUpView()
    }

    private fun setUpView() {
        editTitleRestaurant()
        editImageFood()
        editImageRestaurant()
        editTextFood()
        editTextDeliver()
        setImageLocation()
        setImageClock()
        setDistanceText()
        setTimeText()
        setTextNewRestaurant()
        setTextPromoRestaurant()
        setupRatingBarWithChanges()
    }

    private fun editTitleRestaurant() {
        val labelTitRes: AppCompatTextView = findViewById(R.id.title_res)
        labelTitRes.text = getText(R.string.rest_1)
    }

    private fun editImageFood() {
        val image: AppCompatImageView = findViewById(R.id.bg_image1)
        image.setImageResource(R.drawable.tapa1)
    }

    private fun editImageRestaurant() {
        val image: AppCompatImageView = findViewById(R.id.logo_res1)
        image.setImageResource(R.drawable.casameranilogo)
    }

    private fun editTextFood() {
        val text: AppCompatTextView = findViewById(R.id.res_food1)
        text.text = getText(R.string.food)
    }

    private fun editTextDeliver() {
        val text: AppCompatTextView = findViewById(R.id.res_deliver1)
        text.text = getText(R.string.deliver)
    }

    private fun setImageLocation() {
        val imageLoc: AppCompatImageView = findViewById(R.id.ic_loc1)
        imageLoc.setImageResource(R.drawable.ic_location_on_black_24dp)
    }

    private fun setImageClock() {
        val imageClock: AppCompatImageView = findViewById(R.id.ic_clock1)
        imageClock.setImageResource(R.drawable.ic_clock_black_24dp)
    }

    private fun setDistanceText() {
        val text: AppCompatTextView = findViewById(R.id.res_dist1)
        text.text = getText(R.string.distance)
    }

    private fun setTimeText() {
        val timeText: AppCompatTextView = findViewById(R.id.res_time1)
        timeText.text = getText(R.string.time)
    }

    private fun setTextNewRestaurant() {
        val newRes: AppCompatTextView = findViewById(R.id.new_res)
        newRes.text = getText(R.string.new_res)
    }


    private fun setTextPromoRestaurant() {
        val promoRest: AppCompatTextView = findViewById(R.id.promo_res1)
        promoRest.setText(R.string.promo)
    }

    private fun setupRatingBarWithChanges() {
        val ratingBarChanges: AppCompatRatingBar = findViewById(R.id.rating_bar1)

        setRatingText(numStars = ratingBarChanges.numStars)

        ratingBarChanges.setOnRatingBarChangeListener { ratingBar, rating, _ ->
            setRatingText(rating, ratingBar.numStars)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setRatingText(rating: Float = 0f, numStars: Int) {
        val resRating1: AppCompatTextView = findViewById(R.id.res_rating1)
        resRating1.text = "Puntuación: $rating/$numStars"
    }
}