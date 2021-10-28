package com.jmancebo.pmpd_playground.ut02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.jmancebo.pmpd_playground.R

class TapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_justeat_conslayout)
        setUpView()
    }

    private fun setUpView(){
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
        setRatingStars()
        setTextPromoRestaurant()
    }

    private fun editTitleRestaurant(){
        val labelTitRes : AppCompatTextView = findViewById(R.id.title_res)
        labelTitRes.text = getText(R.string.rest_1)
    }

    private fun editImageFood(){
        val image : AppCompatImageView = findViewById(R.id.bg_image1)
        image.setImageResource(R.drawable.tapa1)
    }

    private fun editImageRestaurant(){
        val image :AppCompatImageView = findViewById(R.id.logo_res1)
        image.setImageResource(R.drawable.casameranilogo)
    }

    private fun editTextFood(){
        val text : AppCompatTextView = findViewById(R.id.res_food1)
        text.text = getText(R.string.food)
    }

    private fun editTextDeliver(){
        val text : AppCompatTextView = findViewById(R.id.res_deliver1)
        text.text = getText(R.string.deliver)
    }

    private fun setImageLocation(){
        val imageLoc : AppCompatImageView = findViewById(R.id.ic_loc1)
        imageLoc.setImageResource(R.drawable.ic_location_on_black_24dp)
    }

    private fun setImageClock(){
        val imageClock : AppCompatImageView = findViewById(R.id.ic_clock1)
        imageClock.setImageResource(R.drawable.ic_clock_black_24dp)
    }

    private fun setDistanceText(){
        val text : AppCompatTextView = findViewById(R.id.res_dist1)
        text.text = getText(R.string.distance)
    }

    private fun setTimeText(){
        val timeText : AppCompatTextView = findViewById(R.id.res_time1)
        timeText.text = getText(R.string.time)
    }

    private fun setTextNewRestaurant(){
        val newRes : AppCompatTextView = findViewById(R.id.new_res)
        newRes.text = getText(R.string.new_res)
    }

    private fun setRatingStars(){
        val star1 : AppCompatImageView = findViewById(R.id.res1_star1)
        val star2 : AppCompatImageView = findViewById(R.id.res1_star2)
        val star3 : AppCompatImageView = findViewById(R.id.res1_star3)
        val star4 : AppCompatImageView = findViewById(R.id.res1_star4)
        val star5 : AppCompatImageView = findViewById(R.id.res1_star5)

        val numberRating : AppCompatTextView = findViewById(R.id.res_rating1)

        star1.setImageResource(R.drawable.ic_star_border_yellow_24dp)
        star2.setImageResource(R.drawable.ic_star_yellow_24dp)
        star3.setImageResource(R.drawable.ic_star_yellow_24dp)
        star4.setImageResource(R.drawable.ic_star_yellow_24dp)
        star5.setImageResource(R.drawable.ic_star_yellow_24dp)

        numberRating.text = getText(R.string.rating)
    }

    private fun setTextPromoRestaurant(){
        val promoRest : AppCompatTextView = findViewById(R.id.promo_res1)
        promoRest.setText(R.string.promo)
    }
}