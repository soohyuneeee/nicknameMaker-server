package nickname.maker.server.domain.user.exception

import nickname.maker.server.domain.user.exception.error.UserErrorProperty
import nickname.maker.server.global.error.exception.MakerException

class UserNotFoundException private constructor() : MakerException(UserErrorProperty.USER_NOT_FOUND) {
    companion object {
        val EXCEPTION = UserNotFoundException()
    }
}
