package pl.senordeveloper.template2024.logging

import org.slf4j.Logger

interface Loggable {
    @Suppress("PropertyName")
    val LOGGER: Logger
    fun e(message: String, throwable: Throwable): Unit
    fun e(format: String, vararg args: Any?): Unit
    fun error(message: String, throwable: Throwable): Unit
    fun error(format: String, vararg args: Any?): Unit
    fun w(message: String, throwable: Throwable): Unit
    fun w(format: String, vararg args: Any?): Unit
    fun warn(message: String, throwable: Throwable): Unit
    fun warn(format: String, vararg args: Any?): Unit
    fun i(message: String, throwable: Throwable): Unit
    fun i(format: String, vararg args: Any?): Unit
    fun info(message: String, throwable: Throwable): Unit
    fun info(format: String, vararg args: Any?): Unit
    fun d(message: String, throwable: Throwable): Unit
    fun d(format: String, vararg args: Any?): Unit
    fun debug(message: String, throwable: Throwable): Unit
    fun debug(format: String, vararg args: Any?): Unit
    fun t(message: String, throwable: Throwable): Unit
    fun t(format: String, vararg args: Any?): Unit
    fun trace(message: String, throwable: Throwable): Unit
    fun trace(format: String, vararg args: Any?): Unit
}
