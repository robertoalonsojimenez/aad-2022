package com.ralonsoj.aad_2022.ut01.ex05.data.local

import android.content.SharedPreferences
import com.google.gson.Gson
import com.ralonsoj.aad_2022.ut01.ex05.domain.User

/**
 * Implement with SharedPreferences
 */
class UsersLocalDataSource (private val sharedPref: SharedPreferences){

    private val gson = Gson()

    //Resuelto Chema:
    fun saveUsers(users: List<User>){
        users.forEach{
            saveUser(it)
        }
    }

    private fun saveUser(user: User){
        val jsonUser = gson.toJson(user, User::class.java)

        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
    }

    /*Mi ejercicio:
    fun saveUsers(user: List<User>){
        val jsonUser = gson.toJson(user, User::class.java)

        val edit = sharedPref.edit()
        edit.putString(user.toString(),jsonUser)
        edit.apply()
    }*/

    fun getUsers(): List<User>{
        val usersList = mutableListOf<User>()
        sharedPref.all.forEach { entry ->
            val users = gson.fromJson(entry.value as String, User::class.java)
            usersList.add(users)
        }
        return usersList
    }

    fun findById(userId: Int): User?{
        val gson = Gson()

        val jsonUser = sharedPref.getString(userId.toString(),"")
        return gson.fromJson(jsonUser, User::class.java)

    }

    fun remove(userId: Int){
        sharedPref.edit().remove(userId.toString()).apply()
    }

}