package co.nimblehq.sample.compose.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.nimblehq.sample.compose.model.UiModel
import co.nimblehq.sample.compose.ui.theme.Dimension

@Composable
fun Item(
    uiModel: UiModel,
    onClick: (String) -> Unit
) {
    val id = uiModel.id.toString()

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick(id) })
    ) {
        Row(modifier = Modifier.padding(Dimension.SpacingNormal)) {
            Text(text = id)
        }
    }
}
