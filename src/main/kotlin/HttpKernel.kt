package __PACKAGE__

import __PACKAGE__.providers.RouteServiceProvider
import dev.alpas.Application
import dev.alpas.ServiceProvider
import dev.alpas.encryption.EncryptionServiceProvider
import dev.alpas.hashing.HashServiceProvider
import dev.alpas.http.HttpKernel
import dev.alpas.logging.LoggerServiceProvider
import dev.alpas.ozone.OzoneProvider
import dev.alpas.session.SessionServiceProvider
import dev.alpas.view.ViewServiceProvider
import kotlin.reflect.KClass

@Suppress("unused")
class HttpKernel : HttpKernel() {
    override fun serviceProviders(app: Application): Iterable<KClass<out ServiceProvider>> {
        return listOf(
            LoggerServiceProvider::class,
            RouteServiceProvider::class,
            ViewServiceProvider::class,
            EncryptionServiceProvider::class,
            HashServiceProvider::class,
            OzoneProvider::class,
            SessionServiceProvider::class
        )
    }
}
