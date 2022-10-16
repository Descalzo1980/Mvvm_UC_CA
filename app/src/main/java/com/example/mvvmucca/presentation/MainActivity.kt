package com.example.mvvmucca.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmucca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.e("AAA", "Activity create")

        viewModel = ViewModelProvider(this,MainViewModelFactory(this))[MainViewModel::class.java]

        val dataTextView = binding.dataTextView
        val dataEditText = binding.dataEditView
        val sendButton = binding.sendButton
        val receiveButton = binding.receiveButton

        viewModel.resultLive.observe(this) {
            dataTextView.text = it
        }

        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            viewModel.save(text)
        }
        receiveButton.setOnClickListener {
            viewModel.load()
        }
    }
}