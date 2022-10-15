package com.example.mvvmucca.domain.usecase

import com.example.mvvmucca.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param : SaveUserNameParam) : Boolean{

        return param.name.isNotEmpty()
    }
}