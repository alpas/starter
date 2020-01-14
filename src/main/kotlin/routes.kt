package __PACKAGE__

import __PACKAGE__.controllers.WelcomeController
import dev.alpas.routing.RouteGroup
import dev.alpas.routing.Router

fun Router.addRoutes() = apply {
    group {
        webRoutesGroup()
    }.middlewareGroup("web")

    apiRoutes()
}

private fun RouteGroup.webRoutesGroup() {
    get("/", WelcomeController::class).name("welcome")
    // register more web routes here
}

private fun Router.apiRoutes() {
    // register API routes here
}
