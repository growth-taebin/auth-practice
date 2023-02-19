package com.example.auth.domain.exception

import com.example.auth.global.exception.BasicException
import com.example.auth.global.exception.enumType.ErrorCode

class InvalidTokenException: BasicException(ErrorCode.INVALID_TOKEN) {
}