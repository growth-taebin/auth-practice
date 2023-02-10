package com.example.auth.service

import com.example.auth.dto.request.SignInRequestDto
import com.example.auth.dto.request.SignUpRequestDto
import com.example.auth.entity.User
import com.example.auth.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserAuthService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {
    @Transactional(rollbackFor = [Exception::class])
    fun signUp(signUpRequestDto: SignUpRequestDto) {
        if (userRepository.existsByEmail(signUpRequestDto.email)) {
            throw RuntimeException()
        }
        userRepository.save(User(id = -1, signUpRequestDto.email, passwordEncoder.encode(signUpRequestDto.password), signUpRequestDto.name))

    }

    @Transactional(rollbackFor = [Exception::class])
    fun signIn(signInRequestDto: SignInRequestDto) {
        val user: User = userRepository.findByEmail(signInRequestDto.email) ?: throw RuntimeException()
        if (!passwordEncoder.matches(signInRequestDto.password, user.password)) {
            throw RuntimeException()
        }
    }
}