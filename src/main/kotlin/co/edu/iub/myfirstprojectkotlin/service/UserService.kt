package co.edu.iub.myfirstprojectkotlin.service

import co.edu.iub.myfirstprojectkotlin.dto.auth.UserResponse
import co.edu.iub.myfirstprojectkotlin.dto.user.UpdateProfileRequest
import co.edu.iub.myfirstprojectkotlin.model.User
import co.edu.iub.myfirstprojectkotlin.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getProfile(currentEmail: String): UserResponse {
        val user = findUserByEmail(currentEmail)
        return user.toResponse()
    }

    fun updateProfile(currentEmail: String, request: UpdateProfileRequest): UserResponse {
        val user = findUserByEmail(currentEmail)

        request.email?.let { newEmail ->
            if (userRepository.existsByEmailAndIdNot(newEmail, requireNotNull(user.id))) {
                throw IllegalArgumentException("Email already exists")
            }
            user.email = newEmail.trim().lowercase()
        }

        request.fullname?.let { user.fullname = it.trim() }

        return userRepository.save(user).toResponse()
    }

    private fun findUserByEmail(email: String) =
        userRepository.findByEmail(email)
            ?: throw IllegalArgumentException("User not found")

    private fun User.toResponse(): UserResponse {
        return UserResponse(
            id = requireNotNull(id),
            email = email,
            fullname = fullname,
            active = active,
            role = role,
            createdAt = createdAt
        )
    }
}