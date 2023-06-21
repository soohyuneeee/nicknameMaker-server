package nickname.maker.server.global.error.exception


open class MakerException(
        val errorCode: ErrorCode,
        message: String,
) : RuntimeException(message) {
    constructor(errorCode: ErrorCode) : this(errorCode, errorCode.message)
}