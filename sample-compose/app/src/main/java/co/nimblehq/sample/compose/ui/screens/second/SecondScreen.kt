package co.nimblehq.sample.compose.ui.screens.second

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import co.nimblehq.sample.compose.R

@Composable
fun SecondScreen(id: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(R.string.id_title, id),
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}
