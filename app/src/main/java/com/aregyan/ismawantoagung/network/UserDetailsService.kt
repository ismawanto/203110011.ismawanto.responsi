package com.aregyan.ismawantoagung.network

import com.aregyan.ismawantoagung.network.model.NetworkUserDetails
import retrofit2.http.GET
import retrofit2.http.Path
//Layanan untuk user detail
interface UserDetailsService {

    @GET("/users/{user}")
    suspend fun getUserDetails(@Path("user") user: String): NetworkUserDetails
}