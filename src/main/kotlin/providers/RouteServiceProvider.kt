package __PACKAGE__.providers

import __PACKAGE__.addRoutes
import dev.alpas.Application
import dev.alpas.make
import dev.alpas.routing.RouteServiceProvider
import dev.alpas.routing.Router

class RouteServiceProvider : RouteServiceProvider() {
    override fun register(app: Application) {
        super.register(app)
        app.make<Router>().addRoutes()
    }
}
