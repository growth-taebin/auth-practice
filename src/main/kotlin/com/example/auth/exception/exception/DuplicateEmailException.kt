package com.example.auth.exception.exception

import com.example.auth.exception.BasicException
import com.example.auth.exception.enumType.ErrorCode

class DuplicateEmailException: BasicException(ErrorCode.DUPLICATE_EMAIL)