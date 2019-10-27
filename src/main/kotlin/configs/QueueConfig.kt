package __PACKAGE__.configs

import dev.alpas.Environment
import dev.alpas.queue.QueueConnectionConfig
import dev.alpas.queue.QueueConfig as BaseConfig

@Suppress("unused")
class QueueConfig(env: Environment) : BaseConfig(env) {
    init {
        val queueNamespace = env("APP_NAME")?.toLowerCase()
        addConnection(
            // default queue name is set to either ACTIVEMQ_DEFAULT_QUEUE_NAME or APP_NAME::default
            QueueConnectionConfig.activeMQ(
                username = env("ACTIVEMQ_USERNAME", "admin"),
                password = env("ACTIVEMQ_PASSWORD", "password"),
                defaultQueueName = env("ACTIVEMQ_DEFAULT_QUEUE_NAME", "$queueNamespace::default"),
                failedQueueName = env("ACTIVEMQ_DEAD_QUEUE_NAME", "$queueNamespace::failed")
            )
        )
    }
}
