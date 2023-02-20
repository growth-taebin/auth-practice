package com.example.auth.domain.user.presentation.data.dto.request

data class SignUpRequestDto(
        val email: String,
        val password: String,
        val name: String
)
