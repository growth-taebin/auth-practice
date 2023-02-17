package com.example.auth.enumType

import org.springframework.security.core.GrantedAuthority

enum class Authority: GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    override fun getAuthority(): String = name

}