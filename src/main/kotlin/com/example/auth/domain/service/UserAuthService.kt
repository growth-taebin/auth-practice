package com.example.auth.domain.service

import com.example.auth.domain.presentation.data.dto.request.SignInRequestDto
import com.example.auth.domain.presentation.data.dto.request.SignUpRequestDto
import com.example.auth.domain.presentation.data.dto.response.SignInResponse
import com.example.auth.domain.entity.User
import com.example.auth.domain.exception.*
import com.example.auth.domain.presentation.data.enumType.Authority
import com.example.auth.exception.exception.*
import com.example.auth.domain.repository.UserRepository
import com.example.auth.global.security.jwt.TokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Collections

@Service
class UserAuthService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val tokenProvider: TokenProvider
        ) {
    @Transactional(rollbackFor = [Exception::class])
    fun signUp(signUpRequestDto: SignUpRequestDto) {
        if (userRepository.existsByEmail(signUpRequestDto.email)) {
            throw DuplicateEmailException()
        }
        userRepository.save(User(id = -1, signUpRequestDto.email, passwordEncoder.encode(signUpRequestDto.password), signUpRequestDto.name, Collections.singletonList(Authority.ROLE_USER)))

    }

    @Transactional(rollbackFor = [Exception::class])
    fun signIn(signInRequestDto: SignInRequestDto): SignInResponse {
        val user: User = userRepository.findByEmail(signInRequestDto.email) ?: throw UserNotFoundException()
        if (!passwordEncoder.matches(signInRequestDto.password, user.password)) {
            throw PasswordNotCorrectException()
        }
        return tokenProvider.generate(signInRequestDto.email)

    }

    fun reissueToken(refreshToken: String): SignInResponse {
        val refreshToken = tokenProvider.parseRefreshToken(refreshToken) ?: throw InvalidTokenException()
        println(refreshToken)
        if(tokenProvider.isRefreshTokenExpired(refreshToken)) {
            println(tokenProvider.isRefreshTokenExpired(refreshToken))
            throw ExpiredRefreshTokenException()
        }
        return tokenProvider.generate(tokenProvider.exactEmailFromRefreshToken(refreshToken))
    }

}