package co.nimblehq.sample.compose.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import co.nimblehq.sample.compose.navigation.Navigation
import co.nimblehq.sample.compose.ui.common.AppBar
import co.nimblehq.sample.compose.ui.theme.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
                Scaffold(topBar = { AppBar() }) { Navigation() }
            }
        }
    }
}
