package __PACKAGE__.database.migrations

import __PACKAGE__.entities.Users
import dev.alpas.auth.PasswordResetTokens
import dev.alpas.ozone.migration.Migration

class CreateUsersTable : Migration() {
    override fun up() {
        createTable(Users, PasswordResetTokens)
    }

    override fun down() {
        dropTable(Users, PasswordResetTokens)
    }
}
