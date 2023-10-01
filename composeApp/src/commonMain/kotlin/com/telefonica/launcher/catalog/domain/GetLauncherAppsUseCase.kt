package com.telefonica.launcher.catalog.domain

import com.telefonica.launcher.catalog.data.LauncherAppsRepo

class GetLauncherAppsUseCase(val repo: LauncherAppsRepo) {
    suspend operator fun invoke() = repo.getLauncherApps()
}