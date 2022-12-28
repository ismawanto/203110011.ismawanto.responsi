package com.aregyan.ismawantoagung.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aregyan.ismawantoagung.domain.UserDetails
// Pada baris 7-14 kelas memiliki tabel SQLite pemetaan dalam database.
@Entity
data class DatabaseUserDetails constructor(
    @PrimaryKey
    val user: String,
    val avatar: String,
    val name: String,
    val userSince: String,
    val location: String
)
// Pada baris 17-23 digunakan untuk membuat fungsi
fun DatabaseUserDetails.asDomainModel(): UserDetails {
    return UserDetails(
        user = user,
        avatar = avatar,
        name = name,
        userSince = userSince,
        location = location
    )
}