package com.ralonsoj.aad_2022.ut01.ex05.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ralonsoj.aad_2022.R
import com.ralonsoj.aad_2022.ut01.ex05.data.UserRepository
import com.ralonsoj.aad_2022.ut01.ex05.data.local.UsersLocalDataSource
import com.ralonsoj.aad_2022.ut01.ex05.data.remote.UsersRemoteDataSource
import com.ralonsoj.aad_2022.ut01.ex05.domain.User

class Ut01Ex05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex05)

        init()
    }

    private fun init(){
        //Obtain from data layer all users
        val userRepository = UserRepository(
            UsersLocalDataSource(this.getPreferences(MODE_PRIVATE)),
            UsersRemoteDataSource()
        )

        val users = userRepository.getUsers()
        Log.d("@dev","Users: $users")

        val users1 = userRepository.getUserById(1)
        Log.d("@dev","$users1")

        userRepository.removeUser(2)

        val users3 = userRepository.getUserById(3)
        Log.d("@dev","$users3")


    }
}