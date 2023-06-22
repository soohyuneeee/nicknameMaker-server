package nickname.maker.server.domain.user.exception

import nickname.maker.server.global.error.exception.ErrorCode
import nickname.maker.server.global.error.exception.MakerException

class UserAlreadyExistsException : MakerException(ErrorCode.USER_ALREADY_EXISTS) {
}