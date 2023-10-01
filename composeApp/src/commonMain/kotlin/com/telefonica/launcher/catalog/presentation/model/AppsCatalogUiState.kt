package com.telefonica.launcher.catalog.presentation.model

import com.telefonica.launcher.catalog.domain.LauncherApp

sealed interface AppsCatalogUiState {
    data object Loading : AppsCatalogUiState
    data class Loaded(val apps: List<LauncherApp>) : AppsCatalogUiState
    data class Error(val error: Throwable) : AppsCatalogUiState
}
