package nickname.maker.server.global.error.exception


open class MakerException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)
