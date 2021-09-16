package com.example.myskills.response

import com.google.gson.annotations.SerializedName

class UserResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val nome: String,
    @SerializedName("username") val usuarioNome: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val telefone: String
)