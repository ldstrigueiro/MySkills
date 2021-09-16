package com.example.myskills.di

import com.example.myskills.viewModel.MainActivityViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainActivityViewModel(get()) }
}