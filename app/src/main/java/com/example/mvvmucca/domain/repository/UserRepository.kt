package com.example.mvvmucca.domain.repository

import com.example.mvvmucca.domain.models.SaveUserNameParam
import com.example.mvvmucca.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam) : Boolean

    fun getName() : UserName
}