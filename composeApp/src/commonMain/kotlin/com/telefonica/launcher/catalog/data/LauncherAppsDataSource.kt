package com.telefonica.launcher.catalog.data

import com.telefonica.launcher.catalog.data.model.LauncherAppDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class LauncherAppsDataSource(
    val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun getLauncherApps(): List<LauncherAppDto> {
        return withContext(dispatcher) {
            delay(1_000)
            listOf(
                LauncherAppDto(
                    name = "Mi Movistar",
                    packageName = "com.movistar.android.mimovistar.es",
                    icon = "",
                    description = """
                        Descarga la app Mi Movistar, la aplicación disponible para clientes de
                        Movistar España y pasa al siguiente nivel de gestión de tus líneas.
                        """.trimIndent(),
                ),
                LauncherAppDto(
                    name = "My O2",
                    packageName = "uk.co.o2.android.myo2",
                    icon = "",
                ),
                LauncherAppDto(
                    name = "Mein Blau",
                    packageName = "telefonica.de.blau",
                    icon = "",
                ),
                LauncherAppDto(
                    name = "Mein O2",
                    packageName = "canvasm.myo2",
                    icon = "",
                ),
                LauncherAppDto(
                    name = "Mi O2",
                    packageName = "es.o2.mio2",
                    icon = "",
                ),
                LauncherAppDto(
                    name = "Meu Vivo",
                    packageName = "br.com.vivo",
                    icon = "",
                ),
            )
        }
    }
}
