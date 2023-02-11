package com.example.auth.controller

import com.example.auth.dto.request.SignInRequestDto
import com.example.auth.dto.request.SignUpRequestDto
import com.example.auth.service.UserAuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
class UserAuthController(
        private val userAuthService: UserAuthService
) {

    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequestDto): ResponseEntity<Void> =
            userAuthService.signUp(request)
                    .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PostMapping("/signin")
    fun signIn(@RequestBody request: SignInRequestDto): ResponseEntity<Void> =
            userAuthService.signIn(request)
                    .let { ResponseEntity.ok().build() }
}