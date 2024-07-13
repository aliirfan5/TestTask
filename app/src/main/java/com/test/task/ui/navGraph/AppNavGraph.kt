package com.test.task.ui.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.test.task.ui.LoginScreen
import com.test.task.ui.MedicineDetailScreen
import com.test.task.ui.MedicineListScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("medicine_list/{username}",
            arguments = listOf(navArgument("username"){type = NavType.StringType})
            ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            username?.let {
                MedicineListScreen(navController, username ?: "User")
            }
        }
        composable(
            "medicine_detail/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            name?.let { MedicineDetailScreen(it) }
        }
    }
}