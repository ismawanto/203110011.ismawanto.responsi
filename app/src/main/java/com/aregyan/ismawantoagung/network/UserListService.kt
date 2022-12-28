package com.aregyan.ismawantoagung.network

import com.aregyan.ismawantoagung.network.model.NetworkUserListItem
import retrofit2.http.GET
//layanan untuk user list
interface UserListService {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUserList(): List<NetworkUserListItem>
}