package com.aregyan.ismawantoagung.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
// Todo 2: Untuk kelas view model
@Parcelize
data class UserDetails(
    val user: String? = "",
    val avatar: String? = "",
    val name: String? = "",
    val userSince: String? = "",
    val location: String? = ""
) : Parcelable