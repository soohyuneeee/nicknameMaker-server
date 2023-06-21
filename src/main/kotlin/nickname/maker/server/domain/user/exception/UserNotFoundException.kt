package nickname.maker.server.domain.user.exception

import nickname.maker.server.global.error.exception.ErrorCode
import nickname.maker.server.global.error.exception.MakerException

object UserNotFoundException: MakerException(ErrorCode.USER_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}