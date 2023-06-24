package nickname.maker.server.domain.like.exception

import nickname.maker.server.global.error.exception.ErrorCode
import nickname.maker.server.global.error.exception.MakerException

class LikeAlreadyExistsException : MakerException(ErrorCode.LIKE_ALREADY_EXISTS) {
}