package __PACKAGE__.configs

import dev.alpas.Environment
import dev.alpas.queue.ActiveMQConnection
import dev.alpas.queue.SyncQueueConnection
import dev.alpas.queue.QueueConfig as BaseConfig

@Suppress("unused")
class QueueConfig(env: Environment) : BaseConfig(env) {
    init {
        addConnection("activemq", lazy { ActiveMQConnection(env) })
        addConnection("sync", lazy { SyncQueueConnection() })
    }
}
