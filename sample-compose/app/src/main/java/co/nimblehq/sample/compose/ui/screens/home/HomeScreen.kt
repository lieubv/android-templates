package co.nimblehq.sample.compose.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import co.nimblehq.sample.compose.navigation.NavigationRoute
import co.nimblehq.sample.compose.ui.screens.xml.HomeViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val uiModels = viewModel.uiModels.collectAsState().value
    val showLoading = viewModel.showLoading.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        ItemList(
            uiModels = uiModels,
            onItemClick = { id -> navController.navigate("${NavigationRoute.SECOND_ROUTE}/$id") }
        )
        if (showLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(alignment = Alignment.Center)
            )
        }
    }
}
