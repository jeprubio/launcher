package com.telefonica.launcher.catalog.presentation

import com.telefonica.launcher.catalog.presentation.model.AppsCatalogUiState
import com.telefonica.launcher.catalog.data.LauncherAppsDataSource
import com.telefonica.launcher.catalog.data.LauncherAppsRepo
import com.telefonica.launcher.catalog.domain.GetLauncherAppsUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppsCatalogScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<AppsCatalogUiState>(AppsCatalogUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getApps()
    }

    private fun getApps() {
        viewModelScope.launch {
            val apps = GetLauncherAppsUseCase(LauncherAppsRepo(LauncherAppsDataSource()))()
            _uiState.update { AppsCatalogUiState.Loaded(apps) }
        }
    }
}
