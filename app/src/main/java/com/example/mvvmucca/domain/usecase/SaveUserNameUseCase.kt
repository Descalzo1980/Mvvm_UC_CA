package com.example.mvvmucca.domain.usecase

import com.example.mvvmucca.domain.models.SaveUserNameParam
import com.example.mvvmucca.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name){
            return true
        }
        return userRepository.saveName(saveParam = param)
    }
}