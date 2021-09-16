package com.example.myskills.di

import com.example.myskills.repository.RepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { RepositoryImpl(get()) }
}