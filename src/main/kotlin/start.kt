package __PACKAGE__

import dev.alpas.AlpasApp
import dev.alpas.make
import dev.alpas.routing.Router

fun main(args: Array<String>) {
    AlpasApp(args).apply {
        make<Router>().addRoutes()
        ignite()
    }
}
