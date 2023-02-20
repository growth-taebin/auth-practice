package com.example.auth.domain.user.entity

import com.example.auth.domain.user.presentation.data.enumType.Authority
import javax.persistence.*

@Entity
class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val email: String,
        val password: String,
        val name: String,
        @Enumerated(EnumType.STRING)
        @ElementCollection
        @CollectionTable(name = "user_authority")
        val authority: MutableList<Authority>
)