package com.example.auth.domain.user.exception

import com.example.auth.global.exception.BasicException
import com.example.auth.global.exception.enumType.ErrorCode

class DuplicateEmailException: BasicException(ErrorCode.DUPLICATE_EMAIL)