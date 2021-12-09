package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jmancebo.pmpd_playground.databinding.AddedFormItemBinding

class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val bind = AddedFormItemBinding.bind(view)

    fun render(model: PlayerViewState) {
        bind.fragmentCardName.text = model.name + " " + model.surname
        bind.fragmentCardGender.text = model.gender
        bind.fragmentCardComunity.text = model.comunity
        bind.fragmentCardPrimaryPosition.text = model.firstPosition
        bind.fragmentCardSecondaryPosition.text = model.secondPosition
    }
}