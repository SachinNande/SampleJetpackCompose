package com.example.samplejetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplejetpackcompose.data.User
import com.example.samplejetpackcompose.utils.UiStates
import com.example.samplejetpackcompose.viewModel.UserViewModel

@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel(),
    onUserClick: (User) -> Unit
) {
    when (val state = viewModel.userStates) {
        is UiStates.Loading -> CircularProgressIndicator()
        is UiStates.Success -> {
            LazyColumn {
                items(state.data) { user ->
                    UserItem(user, onClick = { onUserClick(user) })
                }
            }
        }
        is UiStates.Error -> Text("Error: ${state.error}")
    }
}


@Composable
fun UserItem(user: User, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable{onClick()}, elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${user.name}")
            Text(text = "Username: ${user.username}")
            Text(text = "Email: ${user.email}")
        }
    }
}
