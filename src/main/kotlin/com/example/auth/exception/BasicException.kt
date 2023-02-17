package com.example.auth.exception

import com.example.auth.exception.enumType.ErrorCode

open class BasicException(val errorCode: ErrorCode): RuntimeException(errorCode.message) {
}