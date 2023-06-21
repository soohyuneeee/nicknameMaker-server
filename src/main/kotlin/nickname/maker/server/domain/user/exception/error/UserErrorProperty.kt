package nickname.maker.server.domain.user.exception.error

import nickname.maker.server.global.error.exception.ErrorProperty
import org.springframework.http.HttpStatus

enum class UserErrorProperty(private val status: HttpStatus, private val message: String) : ErrorProperty {
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "사용자가 이미 존재합니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자가 없습니다."),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다."),
    AUTHORITY_MISMATCH(HttpStatus.FORBIDDEN, "권한이 없습니다.");

    override fun getStatus(): HttpStatus = status
    override fun getMessage(): String = message
}
