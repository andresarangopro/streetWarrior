package com.bike.streetwarrior.repository

import com.bike.streetwarrior.entities.UserEntity
import com.bike.streetwarrior.model.User

fun UserEntity.toUserDomain():User {
    return User(
        _id,uid, name, lastName, dni, email, bloodType, bornDate, emergencyContactNumber, emergencyContactName, phoneNumber, profileImage
    )
}
