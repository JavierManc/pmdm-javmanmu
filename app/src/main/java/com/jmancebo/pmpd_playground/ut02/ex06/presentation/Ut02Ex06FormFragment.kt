package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.jmancebo.pmpd_playground.R
import com.jmancebo.pmpd_playground.databinding.FragmentUt02Ex06FormBinding
import com.jmancebo.pmpd_playground.ut02.ex06.data.SharedPrefLocalSource
import com.jmancebo.pmpd_playground.ut02.ex06.domain.SavePlayerUseCase
import com.jmancebo.pmpd_playground.ut02.ex06.serializer.GsonSerializer

class Ut02Ex06FormFragment : Fragment() {

    lateinit var binding: FragmentUt02Ex06FormBinding

    private val viewModel: Ut02Ex06FormViewModel by lazy {
        Ut02Ex06FormViewModel(
            SavePlayerUseCase(
                SharedPrefLocalSource(
                    requireContext(),
                    GsonSerializer(Gson())
                )
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentUt02Ex06FormBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun createInstance() = Ut02Ex06FormFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.formButton.setOnClickListener {
            savePlayer()
        }
    }

    private fun savePlayer() {
        binding.formButton.setOnClickListener {
            viewModel.savePlayer(getPlayerParam())
        }
    }

    private fun getPlayerParam(): SavePlayerUseCase.Param {
        val positions = createPositionList()
        return SavePlayerUseCase.Param(
            binding.inputName.text.toString(),
            binding.inputSurname.text.toString(),
            binding.selectComunity.selectedItem.toString(),
            if (binding.optionFemale.isChecked) {
                getString(R.string.fragment_form_gender_female)
            } else {
                getString(R.string.fragment_form_gender_male)
            },
            positions[0],
            if (positions.size >= 2) {
                positions[1]
            } else {
                ""
            }
        )
    }

    private fun createPositionList(): List<String> {
        val positionList: MutableList<String> = mutableListOf()

        if (binding.optionPositionGoalkeeper.isChecked) {
            positionList.add(getString(R.string.fragment_form_goalkeeper_position))
        }
        if (binding.optionPositionStriker.isChecked) {
            positionList.add(getString(R.string.fragment_form_striker_position))
        }
        if (binding.optionPositionDefender.isChecked) {
            positionList.add(getString(R.string.fragment_form_defender_position))
        }
        if (binding.optionPositionMidfield.isChecked) {
            positionList.add(getString(R.string.fragment_form_midfield_position))
        }

        return positionList
    }


}