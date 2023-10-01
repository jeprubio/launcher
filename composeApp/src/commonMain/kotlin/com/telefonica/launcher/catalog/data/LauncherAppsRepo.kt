package com.telefonica.launcher.catalog.data

import com.telefonica.launcher.catalog.data.model.toLauncherApp
import com.telefonica.launcher.catalog.domain.LauncherApp

class LauncherAppsRepo(
    private val launcherAppsDataSource: LauncherAppsDataSource,
) {

    suspend fun getLauncherApps(): List<LauncherApp> =
        launcherAppsDataSource.getLauncherApps().map { it.toLauncherApp() }
}
