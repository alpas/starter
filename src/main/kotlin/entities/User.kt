package __PACKAGE__.entities

import dev.alpas.auth.Authenticatable
import dev.alpas.auth.UserProvider
import dev.alpas.md5
import dev.alpas.ozone.MigratingTable
import dev.alpas.ozone.bigIncrements
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.Entity
import me.liuwj.ktorm.entity.findById
import me.liuwj.ktorm.entity.findOne
import me.liuwj.ktorm.schema.timestamp
import me.liuwj.ktorm.schema.varchar
import java.time.Instant

interface User : Entity<User>, Authenticatable {
    override var id: Long
    override var email: String
    var name: String?
    val externalId: String
    var createdAt: Instant?
    var updatedAt: Instant?
    val emailVerifiedAt: Instant?

    companion object : Entity.Factory<User>()

    fun gravatarUrl(): String {
        val hash = email.trim().toLowerCase().md5()
        return "//www.gravatar.com/avatar/$hash?s=160&d=robohash"
    }
}

object Users : MigratingTable<User>("users"), UserProvider {
    val id by bigIncrements("id").bindTo { it.id }
    val email by varchar("email").index().unique().bindTo { it.email }
    val name by varchar("name").nullable().bindTo { it.name }
    val externalId by varchar("external_id").bindTo { it.externalId }
    val createdAt by timestamp("created_at").nullable().bindTo { it.createdAt }
    val updatedAt by timestamp("updated_at").nullable().bindTo { it.updatedAt }
    val emailVerifiedAt by timestamp("email_verified_at").nullable().bindTo { it.emailVerifiedAt }

    fun findByExternalId(id: String): User? {
        return findOne { it.externalId eq id }
    }

    override fun findByUsername(username: Any): User? {
        return findOne { it.email.eq(username.toString()) }
    }

    override fun findByPrimaryKey(id: Any): User? {
        return findById(id)
    }
}
