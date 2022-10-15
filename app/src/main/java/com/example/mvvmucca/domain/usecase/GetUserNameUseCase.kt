package com.example.mvvmucca.domain.usecase

import com.example.mvvmucca.domain.models.UserName
import com.example.mvvmucca.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute() : UserName{
        return userRepository.getName()
    }
}