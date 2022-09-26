package com.ralonsoj.aad_2022.ut01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ralonsoj.aad_2022.R
import com.ralonsoj.aad_2022.ut01.data.SharedPreferencesLocalSource
import com.ralonsoj.aad_2022.ut01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreferences()
    }

    private fun initSharedPreferences(){
        //val spCustomer: SharedPreferencesLocalSource = SharedPreferencesLocalSource(this)
        //Es igual a:
        val spCustomer = SharedPreferencesLocalSource(this)
        spCustomer.saveCustomer(Customer(1,"Customer1","Surname1",true))
    }

}