package com.example.mvvmucca.di

import com.example.mvvmucca.repository.UserRepositoryImpl
import com.example.mvvmucca.repository.storage.UserStorage
import com.example.mvvmucca.repository.storage.sharedprefs.SharedPrefUserStorage
import domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository>{
        UserRepositoryImpl(userStorage = get())
    }

}