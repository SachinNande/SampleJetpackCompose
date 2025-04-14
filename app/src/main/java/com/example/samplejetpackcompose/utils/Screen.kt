package com.example.samplejetpackcompose.utils

sealed class Screen(val route: String) {
    object UserList : Screen("user_list")
    object UserDetail : Screen("user_detail/{userId}") {
        fun createRoute(userId: Int): String = "user_detail/$userId"
    }
}