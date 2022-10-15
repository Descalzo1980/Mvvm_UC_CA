package com.example.mvvmucca.domain.usecase

import com.example.mvvmucca.domain.models.UserName

class GetUserNameUseCase {

    fun execute() : UserName{
        return UserName(firstName = "Stas", lastName = "Leonov")
    }
}