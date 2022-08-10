package co.nimblehq.sample.compose.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import co.nimblehq.sample.compose.model.UiModel

@Composable
fun ItemList(
    uiModels: List<UiModel>,
    onItemClick: (String) -> Unit
) {
    val lastItemIndex = uiModels.size - 1

    LazyColumn {
        itemsIndexed(items = uiModels) { index, uiModel ->
            Item(
                uiModel = uiModel,
                onClick = onItemClick
            )
            if (index != lastItemIndex) Divider()
        }
    }
}
