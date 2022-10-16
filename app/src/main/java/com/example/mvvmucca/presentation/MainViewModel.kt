package com.example.mvvmucca.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmucca.repository.UserRepositoryImpl
import com.example.mvvmucca.repository.storage.sharedprefs.SharedPrefUserStorage
import domain.usecase.GetUserNameUseCase
import domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase : GetUserNameUseCase,
    private val saveUserNameUseCase : SaveUserNameUseCase
) : ViewModel() {

    var resultLive = MutableLiveData<String>()


    init {
        Log.e("AAA", "VM create")
    }

    override fun onCleared() {
        Log.e("AAA", "VM create")
        super.onCleared()
    }

    fun save(text : String){
        val params = domain.models.SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        resultLive.value = "Save result = $resultData"
    }

    fun load(){
        val userName: domain.models.UserName = getUserNameUseCase.execute()
        resultLive.value = "${userName.firstName} ${userName.lastName}"
    }
}