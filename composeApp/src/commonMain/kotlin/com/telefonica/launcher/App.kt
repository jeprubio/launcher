package com.telefonica.launcher

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.telefonica.launcher.theme.AppTheme

@Composable
internal fun App(
    systemAppearance: (isLight: Boolean) -> Unit = {}
) = AppTheme(systemAppearance) {

    Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)) {
        Navigator(AppsCatalogScreen())
    }
}

class AppsCatalogScreen: Screen {
    @Composable
    override fun Content() {
        AppsCatalogScreenContent()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppsCatalogScreenContent() {
    MediumTopAppBar(
        title = { Text("Apps Catalog") },
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(100) {
            Card(
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(
                    contentColor = MaterialTheme.colorScheme.background,
                ),
                modifier = Modifier.fillMaxWidth().height(110.dp),
            ) {
                Text("App $it", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

internal expect fun openUrl(url: String?)