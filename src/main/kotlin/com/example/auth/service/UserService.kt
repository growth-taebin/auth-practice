package com.example.auth.service

import com.example.auth.dto.request.SignUpRequestDto
import com.example.auth.entity.User
import com.example.auth.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {
    fun signUp(id: Long, signUpRequestDto: SignUpRequestDto) {
        if (userRepository.existsByEmail(signUpRequestDto.email)) {
            throw RuntimeException()
        }
        userRepository.save(User(id = -1, signUpRequestDto.email, signUpRequestDto.password, signUpRequestDto.name))

    }
}