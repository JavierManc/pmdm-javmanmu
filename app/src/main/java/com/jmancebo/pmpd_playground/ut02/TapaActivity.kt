package com.jmancebo.pmpd_playground.ut02

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
        setRestaurantTitle()
        setUpImageFood()
        setUpRestaurantImage()
        setFoodText()
        setDeliverText()
        setUpLocationImage()
        setUpClockImage()
        setDistanceText()
        setTimeText()
        setNewRestaurantText()
        setPromoRestaurantText()
        setUpRatingBarWithChanges()
    }

    private fun setRestaurantTitle() {
        val labelTitRes: AppCompatTextView = findViewById(R.id.restaurant1_name)
        labelTitRes.text = getText(R.string.rest_name_1)
    }

    private fun setUpImageFood() {
        val image: AppCompatImageView = findViewById(R.id.restaurant1_background_image)
        image.setImageResource(R.drawable.tapa1)
    }

    private fun setUpRestaurantImage() {
        val image: AppCompatImageView = findViewById(R.id.restaurant1_logo)
        image.setImageResource(R.drawable.casameranilogo)
    }

    private fun setFoodText() {
        val text: AppCompatTextView = findViewById(R.id.restaurant1_food)
        text.text = getText(R.string.rest_food1)
    }

    private fun setDeliverText() {
        val text: AppCompatTextView = findViewById(R.id.restaurant1_deliver_time)
        text.text = getText(R.string.rest_deliver1)
    }

    private fun setUpLocationImage() {
        val imageLoc: AppCompatImageView = findViewById(R.id.restauran1_location_icon)
        imageLoc.setImageResource(R.drawable.ic_location_on_black_24dp)
    }

    private fun setUpClockImage() {
        val imageClock: AppCompatImageView = findViewById(R.id.restaurant1_clock_icon)
        imageClock.setImageResource(R.drawable.ic_clock_black_24dp)
    }

    private fun setDistanceText() {
        val text: AppCompatTextView = findViewById(R.id.restaurant1_distance)
        text.text = getText(R.string.rest_distance1)
    }

    private fun setTimeText() {
        val timeText: AppCompatTextView = findViewById(R.id.restaurant1_estimated_time)
        timeText.text = getText(R.string.rest_time1)
    }

    private fun setNewRestaurantText() {
        val newRestaurant: AppCompatTextView = findViewById(R.id.new_restaurant)
        newRestaurant.text = getText(R.string.new_res)
    }


    private fun setPromoRestaurantText() {
        val promoRestaurant: AppCompatTextView = findViewById(R.id.restaurant1_promo)
        promoRestaurant.setText(R.string.promo)
    }

    private fun setUpRatingBarWithChanges() {
        val ratingBarChanges: AppCompatRatingBar = findViewById(R.id.restaurant_rating_bar)

        setRatingText(numStars = ratingBarChanges.numStars)

        ratingBarChanges.setOnRatingBarChangeListener { ratingBar, rating, _ ->
            setRatingText(rating, ratingBar.numStars)
        }
    }

    private fun setRatingText(rating: Float = 0f, numStars: Int) {
        val restaurantRating: AppCompatTextView = findViewById(R.id.restaurant1_rating)
        restaurantRating.text =
            getString(R.string.info_rating_food, rating.toDouble().toString(), numStars)
    }
}