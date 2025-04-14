package com.example.samplejetpackcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplejetpackcompose.utils.UiStates
import com.example.samplejetpackcompose.viewModel.UserViewModel

@Composable
fun UserDetailsScreen(userId: Int, viewModel: UserViewModel = hiltViewModel()) {
    val user = (viewModel.userStates as? UiStates.Success)?.data?.find { it.id == userId }

    if (user != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Name: ${user.name}", style = MaterialTheme.typography.h5)
            Text("Username: ${user.username}")
            Text("Email: ${user.email}")
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("User not found", color = Color.Gray)
        }
    }
}