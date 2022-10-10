package com.ralonsoj.aad_2022.ut01.ex05.data

import com.google.gson.Gson
import com.ralonsoj.aad_2022.ut01.ex05.data.local.UsersLocalDataSource
import com.ralonsoj.aad_2022.ut01.ex05.data.remote.UsersRemoteDataSource
import com.ralonsoj.aad_2022.ut01.ex05.domain.User

class UserRepository (
    val localSource: UsersLocalDataSource,
    val remoteSource: UsersRemoteDataSource){

    // First from Local and them from remote
    fun getUsers(): List<User> {
        var users = localSource.getUsers()
        if (users.isEmpty()){
            users = remoteSource.getUsers()
            localSource.saveUsers(users)
        }
        return users
    }

    fun getUserById(userId: Int): User? {
        val user = localSource.findById(userId)
        if (user == null){
            remoteSource.getUsers()
        }
        return user
    }

    fun removeUser(userId: Int){
        localSource.remove(userId)
    }

}