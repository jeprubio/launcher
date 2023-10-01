package com.telefonica.launcher.catalog.di

import com.telefonica.launcher.catalog.data.LauncherAppsDataSource
import com.telefonica.launcher.catalog.data.LauncherAppsRepo
import com.telefonica.launcher.catalog.domain.GetLauncherAppsUseCase
import org.koin.dsl.module

fun appModule() = module {
    factory { GetLauncherAppsUseCase(get()) }
    factory { LauncherAppsRepo(get()) }
    single { LauncherAppsDataSource() }
}
