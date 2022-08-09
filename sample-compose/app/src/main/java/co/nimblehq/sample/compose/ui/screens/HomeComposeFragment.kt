package co.nimblehq.sample.compose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import co.nimblehq.sample.compose.extension.provideViewModels
import co.nimblehq.sample.compose.ui.base.BaseComposeFragment
import co.nimblehq.sample.compose.ui.screens.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@AndroidEntryPoint
class HomeComposeFragment : BaseComposeFragment() {

    @Inject
    lateinit var navigator: MainNavigator

    //private val viewModel: HomeComposeViewModel by provideViewModels()

    override val composeScreen: @Composable () -> Unit
        get() = {
//            HomeScreen(
//                uiModels = viewModel.uiModels.collectAsState().value,
//                showLoading = false,
//                onItemClick = toaster::display
//            )
        }

    override fun bindViewModel() {
//        viewModel.error bindTo toaster::display
//        viewModel.navigator bindTo navigator::navigate
    }
}
