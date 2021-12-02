package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmancebo.pmpd_playground.R
import com.jmancebo.pmpd_playground.ut02.ex06.domain.SavePlayerUseCase

class ListAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private val dataSet: MutableList<SavePlayerUseCase.Param> = mutableListOf()

    fun setItems(items: List<SavePlayerUseCase.Param>) {
        dataSet.clear()
        addItems(items)
    }

    private fun addItems(items: List<SavePlayerUseCase.Param>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.added_form_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.render(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}