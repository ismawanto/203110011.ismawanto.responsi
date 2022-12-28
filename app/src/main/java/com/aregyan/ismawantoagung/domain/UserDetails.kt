package com.aregyan.ismawantoagung.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
// Model yang digunakan oleh UI dalam user detail
@Parcelize
data class UserDetails(
    val user: String? = "",
    val avatar: String? = "",
    val name: String? = "",
    val userSince: String? = "",
    val location: String? = ""
) : Parcelable