package com.example.auth.domain.user.exception

import com.example.auth.global.exception.BasicException
import com.example.auth.global.exception.enumType.ErrorCode

class PasswordNotCorrectException: BasicException(ErrorCode.PASSWORD_NOT_CORRECT)