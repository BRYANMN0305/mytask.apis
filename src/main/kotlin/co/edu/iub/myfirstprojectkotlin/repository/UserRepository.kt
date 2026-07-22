package co.edu.iub.myfirstprojectkotlin.repository

import co.edu.iub.myfirstprojectkotlin.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
    fun existsByEmail(email: String): Boolean
    fun existsByEmailAndIdNot(email: String, id: Long): Boolean


}