package __PACKAGE__.database.migrations

import __PACKAGE__.entities.Users
import dev.alpas.ozone.migration.Migration

class CreateUsersTable : Migration() {
    override fun up() {
        createTable(Users) {
            addIndex(Users.email)
        }
    }

    override fun down() {
        dropTable(Users)
    }
}
