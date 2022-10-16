package com.example.mvvmucca.repository.storage

import com.example.mvvmucca.repository.storage.models.User

interface UserStorage {

    fun save(user : User) : Boolean

    fun getName() : User

}