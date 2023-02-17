package com.example.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.concurrent.TimeUnit

@RedisHash("refresh-token")
class RefreshToken(
        @Id val email: String,
        val refreshToken: String,
        @TimeToLive(unit = TimeUnit.SECONDS)
        val expiredTime: Long
)