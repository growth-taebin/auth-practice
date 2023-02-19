package com.example.auth.domain.repository

import com.example.auth.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String?): User?

    fun existsByEmail(email: String): Boolean

}