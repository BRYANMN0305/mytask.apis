package co.edu.iub.myfirstprojectkotlin.dto.auth

data class TokenResponse(
    val accessToken: String,
    val tokenType: String = "Bearer",
    val expiresIn: Long
)