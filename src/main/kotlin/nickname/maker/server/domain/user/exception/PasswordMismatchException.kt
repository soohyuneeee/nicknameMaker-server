package nickname.maker.server.domain.user.exception

import nickname.maker.server.domain.user.exception.error.UserErrorProperty
import nickname.maker.server.global.error.exception.MakerException

class PasswordMismatchException private constructor() : MakerException(UserErrorProperty.PASSWORD_MISMATCH) {
    companion object {
        val EXCEPTION = PasswordMismatchException()
    }
}
