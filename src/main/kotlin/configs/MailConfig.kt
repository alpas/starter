package __PACKAGE__.configs

import dev.alpas.Environment
import dev.alpas.mailing.drivers.LocalMailDriver
import dev.alpas.mailing.drivers.SmtpDriver
import dev.alpas.mailing.MailConfig as BaseConfig

// https://alpas.dev/docs/mail
@Suppress("unused")
class MailConfig(env: Environment) : BaseConfig(env) {
    init {
        addDriver("smtp", lazy { SmtpDriver(env) })
        addDriver("local", lazy { LocalMailDriver(env) })
    }
}
