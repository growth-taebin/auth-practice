package com.example.auth.repository

import com.example.auth.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String?): User?

    fun existsByEmail(email: String): Boolean

}