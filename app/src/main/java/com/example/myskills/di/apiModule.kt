package com.example.myskills.di

import com.example.myskills.repository.Repository
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(Repository::class.java) }
}