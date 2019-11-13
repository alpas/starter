package __PACKAGE__

import __PACKAGE__.providers.RouteServiceProvider
import dev.alpas.Application
import dev.alpas.ServiceProvider
import dev.alpas.console.ConsoleKernel
import dev.alpas.encryption.EncryptionServiceProvider
import dev.alpas.hashing.HashServiceProvider
import dev.alpas.logging.LoggerServiceProvider
import dev.alpas.ozone.OzoneProvider
import kotlin.reflect.KClass

@Suppress("unused")
class ConsoleKernel : ConsoleKernel() {
    override fun serviceProviders(app: Application): Iterable<KClass<out ServiceProvider>> {
        return listOf(
            LoggerServiceProvider::class,
            RouteServiceProvider::class,
            EncryptionServiceProvider::class,
            HashServiceProvider::class,
            OzoneProvider::class
        )
    }
}
