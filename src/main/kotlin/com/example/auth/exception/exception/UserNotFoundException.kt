package com.example.auth.exception.exception

import com.example.auth.exception.BasicException
import com.example.auth.exception.enumType.ErrorCode

class UserNotFoundException: BasicException(ErrorCode.USER_NOT_FOUND)