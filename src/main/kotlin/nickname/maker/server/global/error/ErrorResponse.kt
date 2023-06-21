package nickname.maker.server.global.error

import nickname.maker.server.global.error.exception.ErrorCode
import org.springframework.http.HttpStatus

class ErrorResponse(
        val status: HttpStatus,
        val message: String,
) {
    constructor(errorCode: ErrorCode): this(errorCode.status, errorCode.message)
}