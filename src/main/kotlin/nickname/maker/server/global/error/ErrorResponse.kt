package nickname.maker.server.global.error

import nickname.maker.server.global.error.exception.ErrorCode

class ErrorResponse(
        val status: Int,
        val message: String,
) {
    constructor(errorCode: ErrorCode): this(errorCode.status, errorCode.message)
}