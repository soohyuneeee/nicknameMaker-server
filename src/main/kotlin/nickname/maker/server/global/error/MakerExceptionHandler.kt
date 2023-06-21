package nickname.maker.server.global.error

import jakarta.servlet.http.HttpServletRequest
import nickname.maker.server.global.error.exception.ErrorCode
import nickname.maker.server.global.error.exception.MakerException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class MakerExceptionHandler {

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(MakerException::class)
    fun handleMakerException(
            e: MakerException,
            request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(e.errorCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleBadRequest(
            e: MethodArgumentNotValidException,
            request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(
                status = ErrorCode.BAD_REQUEST.status,
                message = "${e.bindingResult.fieldErrors[0].field}의 ${e.bindingResult.fieldErrors[0].defaultMessage}"
        )
    }

    @ExceptionHandler(Exception::class)
    fun handleException(
            e: Exception,
            request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)
    }
}