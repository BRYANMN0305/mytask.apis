package co.edu.iub.myfirstprojectkotlin.controller

import co.edu.iub.myfirstprojectkotlin.dto.auth.RegisterRequest
import co.edu.iub.myfirstprojectkotlin.dto.auth.UserResponse
import co.edu.iub.myfirstprojectkotlin.dto.auth.LoginRequest
import co.edu.iub.myfirstprojectkotlin.dto.auth.TokenResponse
import co.edu.iub.myfirstprojectkotlin.service.AuthService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/register")
    fun register(@Valid @RequestBody request: RegisterRequest): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(authService.register(request))

    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): ResponseEntity<TokenResponse> {
        return ResponseEntity.ok(authService.login(request))
    }

}