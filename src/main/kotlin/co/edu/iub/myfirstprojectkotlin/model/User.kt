package co.edu.iub.myfirstprojectkotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "users")
 class User (
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Long? = null,

   @Column(nullable = false, unique = true)
   var email: String = "",

   @Column(nullable = false)
   var fullname: String = "",

   @Column(nullable = false)
   var password: String? = "",

   @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
   var role: UserRoles = UserRoles.user,

   @Column(nullable = false)
   var active: Boolean = true,

   @Column(nullable = false)
   var createdAt: LocalDateTime = LocalDateTime.now()

)