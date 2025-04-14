package com.example.samplejetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.samplejetpackcompose.UserDetailsScreen
import com.example.samplejetpackcompose.UserScreen
import com.example.samplejetpackcompose.utils.Screen
import com.example.samplejetpackcompose.viewModel.UserViewModel

@Composable
fun AppNavGraph(navController: NavHostController, viewModel: UserViewModel= hiltViewModel()) {
    NavHost(navController = navController, startDestination = Screen.UserList.route) {

        composable(Screen.UserList.route) {
            UserScreen(viewModel = viewModel, onUserClick = { user ->
                navController.navigate(Screen.UserDetail.createRoute(user.id))
            })
        }

        composable(
            route = Screen.UserDetail.route,
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: return@composable
            UserDetailsScreen(userId = userId, viewModel = viewModel)
        }
    }
}
