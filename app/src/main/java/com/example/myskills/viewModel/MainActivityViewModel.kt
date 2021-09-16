package com.example.myskills.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myskills.repository.Repository
import com.example.myskills.response.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MainActivityViewModel(
    private val repository: Repository
) : ViewModel() {

    private val usersList = MutableLiveData<List<UserResponse>>()
    private val errorMessage = MutableLiveData<String>()

    fun fetchUser() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = repository.getUsers()
                    usersList.postValue(result)
                    Log.i("SUCCESS", usersList.toString())
                } catch (throwable: Throwable) {
                    when (throwable) {
                        is IOException -> {
                            Log.e("ERROR", "Problemas de conexão")
                            errorMessage.postValue("Problemas de conexão")
                        }
                        is HttpException -> {
                            val codeError = throwable.code()
                            val errorMessageResponse = throwable.message()
                            Log.e("ERROR", "Error $errorMessageResponse : $codeError")
                            errorMessage.postValue("Error $errorMessageResponse : $codeError")
                        }
                        else -> {
                            errorMessage.postValue("Uknown error")
                        }
                    }
                }
            }
        }

    }
}
