package com.example.auth.domain.repository

import com.example.auth.domain.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken, String>