package com.example.mvvmucca.data.repository

import com.example.mvvmucca.domain.models.SaveUserNameParam
import com.example.mvvmucca.domain.models.UserName
import com.example.mvvmucca.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam) : Boolean{
        return true
    }

    override fun getName() : UserName{
        return UserName(firstName = "Stas", lastName = "Hello from repository")
    }
}