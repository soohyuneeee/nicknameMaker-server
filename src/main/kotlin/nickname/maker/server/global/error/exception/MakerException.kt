package nickname.maker.server.global.error.exception

import nickname.maker.server.domain.user.exception.error.UserErrorProperty


open class MakerException(private val errorProperty: ErrorProperty) : RuntimeException() {
    fun getErrorProperty(): ErrorProperty = errorProperty
}
