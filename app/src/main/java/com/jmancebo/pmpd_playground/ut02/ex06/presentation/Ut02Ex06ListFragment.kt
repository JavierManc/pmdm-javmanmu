package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.jmancebo.pmpd_playground.databinding.FragmentUt02Ex06ListBinding
import com.jmancebo.pmpd_playground.ut02.ex06.data.SharedPrefLocalSource
import com.jmancebo.pmpd_playground.ut02.ex06.domain.GetPlayerUseCase
import com.jmancebo.pmpd_playground.ut02.ex06.domain.SavePlayerUseCase
import com.jmancebo.pmpd_playground.ut02.ex06.serializer.GsonSerializer

class Ut02Ex06ListFragment : Fragment() {

    private lateinit var binding: FragmentUt02Ex06ListBinding

    private val viewModel: Ut02Ex06ListViewModel by lazy {
        Ut02Ex06ListViewModel(
            GetPlayerUseCase(
                SharedPrefLocalSource(
                    requireContext(), GsonSerializer(Gson())
                )
            )
        )
    }

    private val listAdapter = ListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setUpRecycler()
        binding = FragmentUt02Ex06ListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpStateObservers()
        viewModel.getPlayers()
    }

    private fun setUpRecycler() {
        val recyclerView = binding.listAddedForms
        recyclerView.adapter = listAdapter
    }

    private fun setUpStateObservers() {
        val observer = Observer<List<SavePlayerUseCase.Param>> {
            listAdapter.setItems(it)
        }
        viewModel.playerListViewState.observe(viewLifecycleOwner, observer)
    }

    companion object {
        fun createInstance() = Ut02Ex06ListFragment()
    }
}