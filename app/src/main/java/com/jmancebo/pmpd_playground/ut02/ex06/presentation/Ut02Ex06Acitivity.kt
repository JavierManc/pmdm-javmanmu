package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.jmancebo.pmpd_playground.R
import com.jmancebo.pmpd_playground.databinding.ActivityUt02Ex06AcitivityBinding


class Ut02Ex06Acitivity : AppCompatActivity() {

    private val bind: ActivityUt02Ex06AcitivityBinding by lazy {
        ActivityUt02Ex06AcitivityBinding.inflate(layoutInflater)
    }

    private var actualFragment: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun setupView() {
        setContentView(bind.root)
        setupCustomToolbar()
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.ut02_ex06_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.fragment_change -> {
                if (actualFragment == 1) {
                    replaceFragment(bind.container.id, Ut02Ex06ListFragment.createInstance())
                    actualFragment = 2
                    supportActionBar?.title = "Listado de jugadores"
                } else {
                    replaceFragment(bind.container.id, Ut02Ex06FormFragment.createInstance())
                    actualFragment = 1
                    supportActionBar?.title = "Formulario"
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}