package com.aregyan.ismawantoagung.views.userList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aregyan.ismawantoagung.repository.UserListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
//Todo 6: Untuk kelas view model
@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userListRepository: UserListRepository
) : ViewModel() {

    val data = userListRepository.users

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userListRepository.refreshUserList()
        }
    }

}