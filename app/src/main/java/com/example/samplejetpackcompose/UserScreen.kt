package com.example.samplejetpackcompose

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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

@Composable
fun UserScreen(viewModel: UserViewModel = hiltViewModel()) {
//    val users = viewModel.userStates
//    val isLoading = viewModel.userStates.let { UiStates.Loading }
//    val error = viewModel.userStates

    viewModel.userStates.let { it ->
        when (it) {
            is UiStates.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is UiStates.Success -> {
                LazyColumn {
                    items(it.data) { user ->
                        UserItem(user)
                    }
                }
            }
            is UiStates.Error -> {
                Text(text = "Error : ${it.error}", color = androidx.compose.ui.graphics.Color.Red)
            }
        }
    }

//    if (isLoading.) {
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            CircularProgressIndicator()
//        }
//    } else if (error != null) {
//        Text(text = "Error : $error", color = androidx.compose.ui.graphics.Color.Red)
//    } else {
//        LazyColumn {
//            items(users) { user ->
//                UserItem(user)
//            }
//        }
//    }

}

@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${user.name}")
            Text(text = "Username: ${user.username}")
            Text(text = "Email: ${user.email}")
        }
    }
}
