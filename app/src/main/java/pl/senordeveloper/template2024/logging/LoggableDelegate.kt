package pl.senordeveloper.template2024.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

inline fun <reified L : Loggable> loggable(): Loggable = object : Loggable {
    override val LOGGER: Logger = LoggerFactory.getLogger(L::class.java)

    override fun e(message: String, throwable: Throwable) = error(message, throwable)
    override fun e(format: String, vararg args: Any?) = error(format, args)
    override fun error(message: String, throwable: Throwable) = LOGGER.error(message, throwable)
    override fun error(format: String, vararg args: Any?) = LOGGER.error(format, args)

    override fun w(message: String, throwable: Throwable) = warn(message, throwable)
    override fun w(format: String, vararg args: Any?) = warn(format, args)
    override fun warn(message: String, throwable: Throwable) = LOGGER.warn(message, throwable)
    override fun warn(format: String, vararg args: Any?) = LOGGER.warn(format, args)

    override fun i(message: String, throwable: Throwable) = info(message, throwable)
    override fun i(format: String, vararg args: Any?) = info(format, args)
    override fun info(message: String, throwable: Throwable) = LOGGER.info(message, throwable)
    override fun info(format: String, vararg args: Any?) = LOGGER.info(format, args)


    override fun d(message: String, throwable: Throwable) = debug(message, throwable)
    override fun d(format: String, vararg args: Any?) = debug(format, args)
    override fun debug(message: String, throwable: Throwable) = LOGGER.debug(message, throwable)
    override fun debug(format: String, vararg args: Any?) = LOGGER.debug(format, args)

    override fun t(message: String, throwable: Throwable) = trace(message, throwable)
    override fun t(format: String, vararg args: Any?) = trace(format, args)
    override fun trace(message: String, throwable: Throwable) = LOGGER.trace(message, throwable)
    override fun trace(format: String, vararg args: Any?) = LOGGER.trace(format, args)
}