package com.example.myskills

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myskills.viewModel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.fetchUser()
    }
}