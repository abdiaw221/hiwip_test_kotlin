package com.test.kiwip.exceptions

open class DomainException(message: String) : RuntimeException(message)

open class NotFoundException(message: String) : DomainException(message)

open class ConflictException(message: String) : DomainException(message)

open class ForbiddenException(message: String) : DomainException(message)

open class BadRequestException(message: String) : DomainException(message)

interface ErrorCodeProvider {
    val code: String
}