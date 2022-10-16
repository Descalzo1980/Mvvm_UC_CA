package com.example.mvvmucca.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmucca.repository.UserRepositoryImpl
import com.example.mvvmucca.databinding.ActivityMainBinding
import com.example.mvvmucca.repository.storage.sharedprefs.SharedPrefUserStorage
import domain.usecase.GetUserNameUseCase
import domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext)) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val dataTextView = binding.dataTextView
        val dataEditText = binding.dataEditView
        val sendButton = binding.sendButton
        val receiveButton = binding.receiveButton

        sendButton.setOnClickListener{
            val text = dataEditText.text.toString()
            val params = domain.models.SaveUserNameParam(name = text)
            val result : Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }
        receiveButton.setOnClickListener{
            val userName : domain.models.UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}