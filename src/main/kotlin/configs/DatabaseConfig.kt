package __PACKAGE__.configs

import dev.alpas.Environment
import dev.alpas.ozone.ConnectionConfig
import dev.alpas.ozone.DatabaseConfig
import dev.alpas.ozone.MySqlConnection

// https://alpas.dev/docs/database-getting-started
@Suppress("unused")
class DatabaseConfig(env: Environment) : DatabaseConfig(env) {
    init {
        // Uncomment the following line to add database support in your app
        // addConnections(env)
    }

    // https://alpas.dev/docs/database-getting-started#multiple-database-connections
    private fun addConnections(env: Environment) {
        addConnection(
            "mysql",
            lazy {
                MySqlConnection(
                    env,
                    ConnectionConfig(
                        extraParams = mapOf(
                            "useUnicode" to true,
                            "characterEncoding" to "UTF-8",
                            "allowPublicKeyRetrieval" to "true"
                        )
                    )
                )
            })
    }
}
