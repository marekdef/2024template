package pl.senordeveloper.template2024

import android.app.Application
import pl.senordeveloper.template2024.logging.Loggable
import pl.senordeveloper.template2024.logging.loggable

class MainApplication : Application(),
    Loggable by loggable<MainApplication>() {
    override fun onCreate() {
        super.onCreate()
    }
}