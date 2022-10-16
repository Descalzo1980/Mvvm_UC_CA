package com.example.mvvmucca.di

import domain.usecase.GetUserNameUseCase
import domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }
    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}