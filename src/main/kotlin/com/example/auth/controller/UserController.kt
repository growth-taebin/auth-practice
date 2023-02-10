package com.example.auth.controller

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
class UserController(
        private val userAuthService: UserAuthService
) {

    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequestDto): ResponseEntity<Any> =
            userAuthService.signUp(request)
                    .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}