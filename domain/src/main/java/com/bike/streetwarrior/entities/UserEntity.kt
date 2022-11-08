package com.bike.streetwarrior.entities

import com.bike.streetwarrior.empty


data class UserEntity(val _id: String,
                val uid: String,
                val name: String,
                val lastName: String,
                val dni: String,
                val email: String,
                val bloodType: String,
                val bornDate: String,
                val emergencyContactNumber: String,
                val emergencyContactName: String,
                val phoneNumber: String,
                val profileImage: List<String>
){

    companion object {
        val empty = UserEntity(String.empty(),
            String.empty(),
            String.empty(),
            String.empty(),
            String.empty(),
            String.empty(),
            String.empty(),
            String.empty(),
            String.empty(),
            String.empty(),
            String.empty(),
            listOf()
        )
    }
}