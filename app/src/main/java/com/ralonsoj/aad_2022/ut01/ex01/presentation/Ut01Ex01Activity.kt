package com.ralonsoj.aad_2022.ut01.ex01.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ralonsoj.aad_2022.R
import com.ralonsoj.aad_2022.ut01.ex01.data.PreferenceLocalSource
import com.ralonsoj.aad_2022.ut01.ex01.data.SharedPreferenceLocalSource
import com.ralonsoj.aad_2022.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreferences()
        initPreferences()
    }

    private fun initSharedPreferences(){
        //val spCustomer: SharedPreferencesLocalSource = SharedPreferencesLocalSource(this)
        //Es igual a:
        val spCustomer = SharedPreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(2,"Customer2","Surname2",true))

        //Ejemplo de contexto
        ContextCompat.getColor(this,R.color.black)

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev","Customer $newCustomer")
    }

    private fun initPreferences(){
        //val spCustomer: SharedPreferencesLocalSource = SharedPreferencesLocalSource(this)
        //Es igual a:
        val spCustomer = PreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1,"Customer1","Surname1",true))

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev","Customer $newCustomer")
    }

}