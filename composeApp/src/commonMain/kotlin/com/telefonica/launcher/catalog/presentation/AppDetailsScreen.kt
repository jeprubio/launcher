package com.telefonica.launcher.catalog.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.telefonica.launcher.catalog.domain.LauncherApp

class AppsDetails(private val app: LauncherApp) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        AppDetailsScreen(
            app,
            back = { navigator.pop() }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppDetailsScreen(app: LauncherApp, back: () -> Unit) {
    Column {
        TopAppBar(
            title = {
                Text("Details")
            },
            navigationIcon = {
                IconButton(onClick = back) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(app.name, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(app.description)
            Spacer(modifier = Modifier.height(32.dp))
            LazyColumn {
                item {
                    AppDetail(
                        title = "Deeplinks",
                        showChevron = true,
                        bottomSeparator = true,
                    )
                }
                item {
                    AppDetail(
                        title = "Version",
                        showChevron = true,
                        bottomSeparator = true,
                    )
                }
                item {
                    AppDetail(
                        title = "Size",
                        showChevron = true,
                    )
                }
            }
        }
    }
}

@Composable
private fun AppDetail(
    title: String,
    showChevron: Boolean = false,
    bottomSeparator: Boolean = false
) {
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(title)
        Spacer(modifier = Modifier.weight(1f))
        if (showChevron) {
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Chevron")
        }
    }
    if (bottomSeparator) {
        Spacer(
            modifier = Modifier.fillMaxWidth()
                .height(1.dp)
                .background(color = Color(0xFFD1D5E4))
        )
    }
}
