package com.example.auth.domain.presentation.data.dto.request

data class SignUpRequestDto(
        val email: String,
        val password: String,
        val name: String
)
