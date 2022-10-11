package com.ralonsoj.aad_2022.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ralonsoj.aad_2022.R
import com.ralonsoj.aad_2022.ut01.ex02.data.SharedPreferenceLocalSource
import com.ralonsoj.aad_2022.ut01.ex02.domain.Information

class Ut01Ex02Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex02)

        val oInformation = SharedPreferenceLocalSource(this)
        if(checkIsFirstOpened()){
            oInformation.saveInformation(Information(1,false))
            Log.d("@dev","Es la primera vez que se abre la app")
        }else{
            oInformation.saveInformation((Information(1,false)))
            Log.d("@dev","NO es la primera vez que se abre la app")
        }
    }

    private fun checkIsFirstOpened():Boolean{
        val oInformation = SharedPreferenceLocalSource(this)
        val newInformation = oInformation.getInformation()
        return newInformation.isFirstTime
    }

}