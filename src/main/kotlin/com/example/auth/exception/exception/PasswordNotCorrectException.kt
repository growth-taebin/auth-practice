package com.example.auth.exception.exception

import com.example.auth.exception.BasicException
import com.example.auth.exception.enumType.ErrorCode

class PasswordNotCorrectException: BasicException(ErrorCode.PASSWORD_NOT_CORRECT)