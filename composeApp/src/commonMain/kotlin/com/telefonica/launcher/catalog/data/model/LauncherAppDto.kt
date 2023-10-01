package com.telefonica.launcher.catalog.data.model

import com.telefonica.launcher.catalog.domain.LauncherApp

data class LauncherAppDto(
    val name: String,
    val packageName: String,
    val icon: String,
    val description: String = "",
)

fun LauncherAppDto.toLauncherApp() = LauncherApp(
    name = name,
    packageName = packageName,
    icon = icon,
    description = description,
)
