package co.edu.iub.myfirstprojectkotlin.dto.auth

import co.edu.iub.myfirstprojectkotlin.model.UserRoles
import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val email: String,
    val fullname: String,
    val role: UserRoles,
    val active: Boolean,
    val createdAt: LocalDateTime,

    )