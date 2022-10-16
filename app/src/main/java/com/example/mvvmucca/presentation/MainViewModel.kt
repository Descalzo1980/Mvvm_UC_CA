package com.example.mvvmucca.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.usecase.GetUserNameUseCase
import domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase : GetUserNameUseCase,
    private val saveUserNameUseCase : SaveUserNameUseCase
) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive : LiveData<String> = resultLiveMutable


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
        resultLiveMutable.value = "Save result = $resultData"
    }

    fun load(){
        val userName: domain.models.UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}