package com.ralonsoj.aad_2022.ut01.ex01.data

import android.app.Activity
import android.content.Context
import com.ralonsoj.aad_2022.ut01.ex01.domain.Customer

class PreferenceLocalSource (private val activity: Activity){
    val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)

    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()

        //Kotlin Style:
        editor.apply{
            putInt("id", customer.id)
            putString("name",customer.name)
            putString("surname",customer.surname)
            putBoolean("is_active",customer.isActive)
            apply()
        }

        //Java Style
        /*
        editor.putInt("id", customer.id)
        editor.putString("name",customer.name)
        editor.putString("surname",customer.surname)
        editor.putBoolean("is_active",customer.isActive)
        editor.apply() - Asíncrono (Se hace en otro hilo diferente que el que sigue editor)
        editor.commit() - Síncrono (Se hace en el mismo hilo que el que sigue editor)
        */
    }

    fun getCustomer(): Customer {
        return Customer(
            sharedPref.getInt("id",0),
            // ?: es un operador ternario para que si el bloque es nulo devuelva "no existe"
            sharedPref.getString("name", "no existe") ?: "no existe",
            sharedPref.getString("surname", "no existe") ?: "no existe",
            sharedPref.getBoolean("is_active", true)
        )
    }
}