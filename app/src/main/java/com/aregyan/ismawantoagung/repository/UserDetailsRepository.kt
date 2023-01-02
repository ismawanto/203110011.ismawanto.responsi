package com.aregyan.ismawantoagung.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.aregyan.ismawantoagung.database.UsersDatabase
import com.aregyan.ismawantoagung.database.asDomainModel
import com.aregyan.ismawantoagung.domain.UserDetails
import com.aregyan.ismawantoagung.network.UserDetailsService
import com.aregyan.ismawantoagung.network.model.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject
// Todo 3: Berisi semua repositori user detail
class UserDetailsRepository @Inject constructor(
    private val userDetailsService: UserDetailsService,
    private val database: UsersDatabase
) {

    fun getUserDetails(user: String): LiveData<UserDetails> {
        return Transformations.map(database.usersDao.getUserDetails(user)) {
            it?.asDomainModel()
        }
    }


    suspend fun refreshUserDetails(user: String) {
        try {
            val userDetails = userDetailsService.getUserDetails(user)
            database.usersDao.insertUserDetails(userDetails.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }

}