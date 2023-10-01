package com.telefonica.launcher.catalog.presentation

import com.telefonica.launcher.catalog.presentation.model.AppsCatalogUiState
import com.telefonica.launcher.catalog.domain.GetLauncherAppsUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AppsCatalogScreenViewModel : ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow<AppsCatalogUiState>(AppsCatalogUiState.Loading)
    val uiState = _uiState.asStateFlow()
    private val getLauncherUseCase: GetLauncherAppsUseCase by inject()

    init {
        getApps()
    }

    private fun getApps() {
        viewModelScope.launch {
            val apps = getLauncherUseCase()
            _uiState.update { AppsCatalogUiState.Loaded(apps) }
        }
    }
}
