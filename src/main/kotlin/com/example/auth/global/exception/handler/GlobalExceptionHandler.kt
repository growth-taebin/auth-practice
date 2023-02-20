package com.example.auth.global.exception.handler

import com.example.auth.global.exception.BasicException
import com.example.auth.global.exception.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BasicException::class)
    fun globalExceptionHandler(e: BasicException): ResponseEntity<ErrorResponse> =
            ResponseEntity(
                    ErrorResponse(e.errorCode.message, e.errorCode.status),
                    HttpStatus.valueOf(e.errorCode.status)
            )
}