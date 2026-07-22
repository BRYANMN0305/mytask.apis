package co.edu.iub.myfirstprojectkotlin.service

import co.edu.iub.myfirstprojectkotlin.dto.auth.RegisterRequest
import co.edu.iub.myfirstprojectkotlin.dto.auth.UserResponse
import co.edu.iub.myfirstprojectkotlin.dto.auth.LoginRequest
import co.edu.iub.myfirstprojectkotlin.dto.auth.TokenResponse
import co.edu.iub.myfirstprojectkotlin.model.User
import co.edu.iub.myfirstprojectkotlin.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService
) {
     fun register(request: RegisterRequest): UserResponse {
        val email = request.email.trim().lowercase()
        if (userRepository.existsByEmail(email)) {
            throw ResponseStatusException(
                HttpStatus.CONFLICT,
                "Email already exists"

            )
        }

        val user = User(
            email = email,
            fullname = request.fullname.trim(),
            password = passwordEncoder.encode(request.password)!!
        )
        return userRepository.save(user).toResponse()
    }

    fun User.toResponse(): UserResponse {
        return UserResponse(
            id = requireNotNull(id),
            email = email,
            fullname = fullname,
            active = active,
            role = role,
            createdAt = createdAt,
        )
    }

    fun login(request: LoginRequest): TokenResponse {
        val email = request.email.trim().lowercase()
        val user = userRepository.findByEmail(email)
            ?: throw IllegalArgumentException("Invalid credentials")

        if (!user.active || !passwordEncoder.matches(request.password, user.password)) {
            throw IllegalArgumentException("Invalid credentials")
        }

        val token = jwtService.generateToken(user)
        return TokenResponse(
            accessToken = token,
            expiresIn = jwtService.expirationMinutes * 60
        )
    }
}