package com.ralonsoj.aad_2022.ut01.ex02.data

import android.content.Context
import com.ralonsoj.aad_2022.R
import com.ralonsoj.aad_2022.ut01.ex02.domain.Information

class SharedPreferenceLocalSource(val context: Context){

    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_ut01ex02), Context.MODE_PRIVATE)

    fun saveInformation(information: Information){
        val editor = sharedPref.edit()

        editor.apply{
            putInt("id", information.id)
            putBoolean("is_first_opened",information.isFirstTime)
            apply()
        }
    }

    fun getInformation(): Information {
        return Information(
            sharedPref.getInt("id",0),
            sharedPref.getBoolean("is_first_opened", true)
        )
    }

}