package com.aregyan.ismawantoagung.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aregyan.ismawantoagung.domain.UserListItem
//Pada kelas memiliki tabel SQLite pemetaan dalam database.
@Entity
data class DatabaseUserListItem constructor(
    @PrimaryKey
    val id: Int,
    val avatar: String,
    val username: String
)
//membuat domain model dari database userlistitem
fun List<DatabaseUserListItem>.asDomainModel(): List<UserListItem> {
    return map {
        UserListItem(
            id = it.id,
            avatar = it.avatar,
            username = it.username
        )
    }
}