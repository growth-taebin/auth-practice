package com.example.auth.domain.user.exception

import com.example.auth.global.exception.BasicException
import com.example.auth.global.exception.enumType.ErrorCode

class UserNotFoundException: BasicException(ErrorCode.USER_NOT_FOUND)