package com.example.mvvmucca.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmucca.data.repository.UserRepositoryImpl
import com.example.mvvmucca.databinding.ActivityMainBinding
import com.example.mvvmucca.domain.models.SaveUserNameParam
import com.example.mvvmucca.domain.models.UserName
import com.example.mvvmucca.domain.usecase.GetUserNameUseCase
import com.example.mvvmucca.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val getUserNameUseCase = GetUserNameUseCase()
    private val userRepository = UserRepositoryImpl()
    private val saveUserNameUseCase = SaveUserNameUseCase(userRepository = userRepository)

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
            val params = SaveUserNameParam(name = text)
            val result : Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }
        receiveButton.setOnClickListener{
            val userName : UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}