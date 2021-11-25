package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.jmancebo.pmpd_playground.R
import com.jmancebo.pmpd_playground.databinding.ActivityUt02Ex06AcitivityBinding
import com.jmancebo.pmpd_playground.ut02.ex06.domain.PlayerModel

class Ut02Ex06Acitivity : AppCompatActivity() {

    private val bind: ActivityUt02Ex06AcitivityBinding by lazy {
        ActivityUt02Ex06AcitivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun setupView() {
        setContentView(bind.root)
        setupCustomToolbar()
        //addFragment(bind.container.id, Ut02Ex06ListFragment.createInstance(), "2")
        addFragment(bind.container.id, Ut02Ex06FormFragment.createInstance(), "1")
    }

    private fun setupCustomToolbar() {
        setSupportActionBar(bind.formCustomToolbar.toolbar)
        supportActionBar?.title = "Formulario"
    }

    private fun addFragment(layoutId: Int, fragment: Fragment, tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(layoutId, fragment, tag)
        fragmentTransaction.commit()
    }

    private fun replaceFragment(layoutId: Int, fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(layoutId, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun formButton() {
        val fragment = Ut02Ex06FormFragment.createInstance()
        fragment.binding.fragmentFormButton.setOnClickListener {
            val player = PlayerModel(
                fragment.binding.formNameEdit.toString(),
                fragment.binding.formSurnameEdit.toString(),
                fragment.binding.formComunitySelection.selectedItem.toString(),
                if (fragment.binding.formGenderFemale.isChecked) {
                    "Female"
                } else {
                    "Male"
                },
                createPositionList()
            )

            Log.d("@dev", player.toString())
        }


    }

    private fun createPositionList(): List<String> {
        val positionList: MutableList<String> = mutableListOf()

        val fragment = Ut02Ex06FormFragment.createInstance()
        if (fragment.binding.formPositionGoalkeeper.isChecked) {
            positionList.add("Portero")
        }
        if (fragment.binding.formPositionStriker.isChecked) {
            positionList.add("Delantero")
        }
        if (fragment.binding.formPositionDefender.isChecked) {
            positionList.add("Defensa")
        }
        if (fragment.binding.formPositionMidfield.isChecked) {
            positionList.add("Mediocentro")
        }

        return positionList
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.ut02_ex06_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.fragment_change -> {
                //replaceFragment(bind.container.id, Ut02Ex06FormFragment.createInstance())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}