package co.edu.iub.myfirstprojectkotlin.dto.user

import jakarta.validation.constraints.Email

data class UpdateProfileRequest(
    @field:Email
    val email: String?,

    val fullname: String?
)