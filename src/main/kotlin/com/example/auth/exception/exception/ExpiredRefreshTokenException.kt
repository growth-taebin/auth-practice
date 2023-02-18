package com.example.auth.exception.exception

import com.example.auth.exception.BasicException
import com.example.auth.exception.enumType.ErrorCode

class ExpiredRefreshTokenException: BasicException(ErrorCode.REFRESH_TOKEN_EXPIRED) {
}