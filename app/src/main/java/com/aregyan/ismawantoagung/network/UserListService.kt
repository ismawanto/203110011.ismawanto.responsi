package com.aregyan.ismawantoagung.network

import com.aregyan.ismawantoagung.network.model.NetworkUserListItem
import retrofit2.http.GET
// Todo 1: Untuk mengambil data dari internet
interface UserListService {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUserList(): List<NetworkUserListItem>
}