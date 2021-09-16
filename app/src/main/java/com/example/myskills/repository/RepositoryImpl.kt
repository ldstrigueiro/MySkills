package com.example.myskills.repository


class RepositoryImpl(
    private val repository: Repository
){
    suspend fun repoGetUsers() = repository.getUsers()
}