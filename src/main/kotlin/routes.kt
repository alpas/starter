package __PACKAGE__

import __PACKAGE__.controllers.WelcomeController
import dev.alpas.routing.Router

fun Router.addRoutes() = apply {
    webRoutes()
}

private fun Router.webRoutes() {
    get("/", WelcomeController::class).name("welcome")
}

