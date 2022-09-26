package com.ralonsoj.aad_2022.ut01.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.ralonsoj.aad_2022.R
import com.ralonsoj.aad_2022.ut01.domain.Customer

class SharedPreferencesLocalSource(val activity: AppCompatActivity){

    val sharedPref = activity.getSharedPreferences(
        activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE)

    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()
        editor.putInt("id", customer.id)
        editor.putString("name",customer.name)
        editor.putString("surname",customer.surname)
        editor.putBoolean("is_active",customer.isActive)
        editor.apply() //Asíncrono
        //editor.commit() Síncrono (Se hace en el mismo hilo que editor etc)

    }

}
