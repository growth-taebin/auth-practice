package com.example.auth.dto

data class UserDto(
        val id: Long,
        val email: String,
        val password: String,
        val name: String
)
