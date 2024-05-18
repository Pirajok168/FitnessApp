package ru.fitness.mobile.data.web.model

import kotlinx.serialization.Serializable

@Serializable
enum class UserTypePayload {
    Coach,
    User
}