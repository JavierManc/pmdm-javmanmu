package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jmancebo.pmpd_playground.databinding.FragmentUt02Ex06ListBinding

class Ut02Ex06ListFragment : Fragment() {

    private lateinit var binding: FragmentUt02Ex06ListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUt02Ex06ListBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun createInstance() = Ut02Ex06ListFragment()
    }
}