package com.example.mvvmucca.data.repository

import android.content.Context
import com.example.mvvmucca.domain.models.SaveUserNameParam
import com.example.mvvmucca.domain.models.UserName
import com.example.mvvmucca.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prest_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_LAST_NAME = "Default name"

class UserRepositoryImpl(context: Context) : UserRepository {

   private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam) : Boolean{

        sharedPreferences.edit().putString(KEY_FIRST_NAME,saveParam.name).apply()
        return true
    }

    override fun getName() : UserName{

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME,"") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME,DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return UserName(firstName = firstName, lastName = lastName)
    }
}