package com.example.auth.exception.enumType

enum class ErrorCode(
        val message: String,
        val status: Int
) {

    USER_NOT_FOUND("유저를 찾을 수 없습니다.", 404),
    DUPLICATE_EMAIL("중복된 이메일 입니다.", 409),
    PASSWORD_NOT_CORRECT("비밀번호가 일치하지 않습니다.", 400)
}