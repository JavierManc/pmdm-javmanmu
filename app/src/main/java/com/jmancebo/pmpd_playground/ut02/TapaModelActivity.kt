package com.jmancebo.pmpd_playground.ut02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.appcompat.widget.AppCompatTextView
import com.jmancebo.pmpd_playground.R

class TapaModelActivity : AppCompatActivity() {

    val tapaViewModel: TapaViewModel = TapaViewModel()
    private lateinit var labelTitResText: AppCompatTextView
    private lateinit var labelFoodText: AppCompatTextView
    private lateinit var labelDeliverText: AppCompatTextView
    private lateinit var labelDistanceText: AppCompatTextView
    private lateinit var labelTimeText: AppCompatTextView
    private lateinit var labelNewResText: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_justeat_conslayout)
        setUpView()
        render(tapaViewModel.getTapa())
    }

    private fun setUpView() {
        labelTitResText = findViewById(R.id.title_res)
        labelFoodText = findViewById(R.id.res_food1)
        labelDeliverText = findViewById(R.id.res_deliver1)
        labelDistanceText = findViewById(R.id.res_dist1)
        labelTimeText = findViewById(R.id.res_time1)
        labelNewResText = findViewById(R.id.new_res)
        setUpImageFood()
        setUpRestaurantImage()
        setUpLocationImage()
        setUpClockImage()
        setUpRatingBarWithChanges()
    }

    private fun setUpImageFood() {
        val image: AppCompatImageView = findViewById(R.id.bg_image1)
        image.setImageResource(R.drawable.tapa1)
    }

    private fun setUpRestaurantImage() {
        val image: AppCompatImageView = findViewById(R.id.logo_res1)
        image.setImageResource(R.drawable.casameranilogo)
    }

    private fun setUpLocationImage() {
        val imageLoc: AppCompatImageView = findViewById(R.id.ic_loc1)
        imageLoc.setImageResource(R.drawable.ic_location_on_black_24dp)
    }

    private fun setUpClockImage() {
        val imageClock: AppCompatImageView = findViewById(R.id.ic_clock1)
        imageClock.setImageResource(R.drawable.ic_clock_black_24dp)
    }

    private fun setUpRatingBarWithChanges() {
        val ratingBarChanges: AppCompatRatingBar = findViewById(R.id.rating_bar1)

        setRatingText(numStars = ratingBarChanges.numStars)

        ratingBarChanges.setOnRatingBarChangeListener { ratingBar, rating, _ ->
            setRatingText(rating, ratingBar.numStars)
        }
    }

    private fun setRatingText(rating: Float = 0f, numStars: Int) {
        val resRating1: AppCompatTextView = findViewById(R.id.res_rating1)
        resRating1.text =
            getString(R.string.info_rating_food, rating.toDouble().toString(), numStars)
    }

    private fun render(tapa: TapaModel) {
        labelTitResText.text = getText(tapa.titleRestaurant)
        labelFoodText.text = getText(tapa.foodText)
        labelDeliverText.text = getText(tapa.deliverText)
        labelDistanceText.text = getText(tapa.resDistance)
        labelTimeText.text = getText(tapa.resTime)
        labelNewResText.text = getText(tapa.newRes)
    }
}