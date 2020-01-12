package __PACKAGE__

import dev.alpas.Application
import dev.alpas.ServiceProvider
import dev.alpas.encryption.EncryptionServiceProvider
import dev.alpas.hashing.HashServiceProvider
import dev.alpas.http.HttpKernel
import dev.alpas.logging.LoggerServiceProvider
import dev.alpas.ozone.OzoneServiceProvider
import dev.alpas.queue.QueueServiceProvider
import dev.alpas.routing.RouteServiceProvider
import dev.alpas.session.SessionServiceProvider
import dev.alpas.view.ViewServiceProvider
import kotlin.reflect.KClass

@Suppress("unused")
class HttpKernel : HttpKernel() {
    override fun serviceProviders(app: Application): Iterable<KClass<out ServiceProvider>> {
        return listOf(
            LoggerServiceProvider::class,
            EncryptionServiceProvider::class,
            HashServiceProvider::class,
            SessionServiceProvider::class,
            RouteServiceProvider::class,
            ViewServiceProvider::class,
            OzoneServiceProvider::class,
            QueueServiceProvider::class
        )
    }
}
