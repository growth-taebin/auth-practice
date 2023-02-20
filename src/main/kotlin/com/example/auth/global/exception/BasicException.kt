package com.example.auth.global.exception

import com.example.auth.global.exception.enumType.ErrorCode

open class BasicException(val errorCode: ErrorCode): RuntimeException(errorCode.message)