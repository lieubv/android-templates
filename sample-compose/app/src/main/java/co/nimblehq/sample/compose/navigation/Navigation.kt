package co.nimblehq.sample.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import co.nimblehq.sample.compose.ui.screens.home.HomeScreen
import co.nimblehq.sample.compose.ui.screens.second.SecondScreen

object NavigationRoute {
    const val HOME_ROUTE = "home"
    const val SECOND_ROUTE = "second"
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoute.HOME_ROUTE) {
        composable(route = NavigationRoute.HOME_ROUTE) {
            HomeScreen(navController = navController)
        }
        composable(
            route = NavigationRoute.SECOND_ROUTE + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            SecondScreen(id = navBackStackEntry.arguments?.getString("id") ?: "")
        }
    }
}
