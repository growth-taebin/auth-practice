package com.example.auth.domain.presentation

import com.example.auth.domain.presentation.data.dto.request.SignInRequestDto
import com.example.auth.domain.presentation.data.dto.request.SignUpRequestDto
import com.example.auth.domain.presentation.data.dto.response.SignInResponse
import com.example.auth.domain.service.UserAuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
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
    fun signIn(@RequestBody request: SignInRequestDto): ResponseEntity<SignInResponse> =
            userAuthService.signIn(request)
                    .let { ResponseEntity.ok(it) }

    @PatchMapping("/reissue")
    fun reissueToken(@RequestHeader refreshToken: String): ResponseEntity<SignInResponse> =
            userAuthService.reissueToken(refreshToken)
                    .let { ResponseEntity.ok(it) }
}