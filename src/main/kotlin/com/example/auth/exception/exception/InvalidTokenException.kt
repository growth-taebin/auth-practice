package com.example.auth.exception.exception

import com.example.auth.exception.BasicException
import com.example.auth.exception.enumType.ErrorCode

class InvalidTokenException: BasicException(ErrorCode.INVALID_TOKEN) {
}