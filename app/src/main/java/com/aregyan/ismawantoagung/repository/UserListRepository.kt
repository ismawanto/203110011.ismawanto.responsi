package com.aregyan.ismawantoagung.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.aregyan.ismawantoagung.database.UsersDatabase
import com.aregyan.ismawantoagung.database.asDomainModel
import com.aregyan.ismawantoagung.domain.UserListItem
import com.aregyan.ismawantoagung.network.UserListService
import com.aregyan.ismawantoagung.network.model.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject
//Berisi semua repositori user list
class UserListRepository @Inject constructor(
    private val userListService: UserListService,
    private val database: UsersDatabase
) {

    val users: LiveData<List<UserListItem>> =
        Transformations.map(database.usersDao.getDatabaseUsers()) {
            it.asDomainModel()
        }

    suspend fun refreshUserList() {
        try {
            val users = userListService.getUserList()
            database.usersDao.insertAll(users.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}