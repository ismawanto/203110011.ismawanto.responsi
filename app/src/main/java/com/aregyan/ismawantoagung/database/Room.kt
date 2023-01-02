package com.aregyan.ismawantoagung.database

import androidx.lifecycle.LiveData
import androidx.room.*
// Todo 4: Untuk kelas database.
@Dao
interface UsersDao {

    // Pada baris 10-11 Untuk menampilkan tabel database dalam apilkasi pada daftar pengguna.
    @Query("select * from DatabaseUserListItem")
    fun getDatabaseUsers(): LiveData<List<DatabaseUserListItem>>
    // Pada baris 13-14 untuk memasukkan semua user list
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<DatabaseUserListItem>)

    // Pada baris 17-18 Untuk menampilkan tabel database dalam apilkasi pada pengguna tunggal.
    @Query("select * from DatabaseUserDetails WHERE user LIKE :user")
    fun getUserDetails(user: String): LiveData<DatabaseUserDetails>
    // Pada baris 19-20 untuk memasukkan semua user detail
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserDetails(databaseUserDetails: DatabaseUserDetails)
}
//Pada baris 23-26 Kelas yang dianotasi dengan @Entity.
@Database(entities = [DatabaseUserListItem::class, DatabaseUserDetails::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {
    abstract val usersDao: UsersDao
}