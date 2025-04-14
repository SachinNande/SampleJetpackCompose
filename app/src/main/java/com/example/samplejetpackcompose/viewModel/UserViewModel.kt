package com.example.samplejetpackcompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplejetpackcompose.data.User
import com.example.samplejetpackcompose.data.repository.UserRepository
import com.example.samplejetpackcompose.utils.UiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.URL
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    var userStates by mutableStateOf<UiStates<List<User>>>(UiStates.Loading)
        private set

    init {
        getUserList()
    }

    private fun getUserList() {
        viewModelScope.launch {
            userStates = UiStates.Loading
            try {
                val result = repository.getUser()
                userStates = UiStates.Success(result)
            } catch (e: Exception) {
                userStates = UiStates.Error(e.message.toString())
            }
        }
    }
}