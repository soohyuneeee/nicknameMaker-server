package nickname.maker.server.domain.user.exception

import nickname.maker.server.global.error.exception.ErrorCode
import nickname.maker.server.global.error.exception.MakerException

class PasswordMismatchException : MakerException(ErrorCode.PASSWORD_MISMATCH) {
}
