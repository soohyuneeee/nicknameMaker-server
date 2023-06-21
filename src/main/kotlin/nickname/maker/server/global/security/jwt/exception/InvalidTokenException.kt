package nickname.maker.server.global.security.jwt.exception

import nickname.maker.server.global.error.exception.ErrorCode
import nickname.maker.server.global.error.exception.MakerException

object InvalidTokenException : MakerException(ErrorCode.INVALID_TOKEN) {
    val EXCEPTION by lazy { this }
}