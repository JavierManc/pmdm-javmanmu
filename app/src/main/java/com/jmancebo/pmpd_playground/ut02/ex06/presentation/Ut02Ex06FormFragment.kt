package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.jmancebo.pmpd_playground.databinding.FragmentUt02Ex06FormBinding
import com.jmancebo.pmpd_playground.ut02.ex06.data.SharedPrefLocalSource
import com.jmancebo.pmpd_playground.ut02.ex06.domain.SavePlayerUseCase
import com.jmancebo.pmpd_playground.ut02.ex06.serializer.GsonSerializer

class Ut02Ex06FormFragment : Fragment() {

    lateinit var binding: FragmentUt02Ex06FormBinding

    lateinit var viewModel: Ut02Ex06FormViewModel

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
        binding.fragmentFormButton.setOnClickListener {
            savePlayer()
        }
    }

    private fun savePlayer() {
        binding.fragmentFormButton.setOnClickListener {
            val player = getPlayerParam()
            viewModel.savePlayer(player)
        }
    }

    private fun getPlayerParam(): SavePlayerUseCase.Param {
        val positions = createPositionList()
        return SavePlayerUseCase.Param(
            binding.formNameEdit.toString(),
            binding.formSurnameEdit.toString(),
            binding.formComunitySelection.selectedItem.toString(),
            if (binding.formGenderFemale.isChecked) {
                "Female"
            } else {
                "Male"
            },
            positions[0],
            if (positions.size >= 2) {
                positions[1]
            } else {
                ""
            },
            if (positions.size >= 3) {
                positions[2]
            } else {
                ""
            }
        )
    }

    private fun createPositionList(): List<String> {
        val positionList: MutableList<String> = mutableListOf()

        if (binding.formPositionGoalkeeper.isChecked) {
            positionList.add("Portero")
        }
        if (binding.formPositionStriker.isChecked) {
            positionList.add("Delantero")
        }
        if (binding.formPositionDefender.isChecked) {
            positionList.add("Defensa")
        }
        if (binding.formPositionMidfield.isChecked) {
            positionList.add("Mediocentro")
        }

        return positionList
    }


}