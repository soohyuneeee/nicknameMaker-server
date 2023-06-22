package nickname.maker.server.global.error

import jakarta.servlet.http.HttpServletRequest
import nickname.maker.server.global.error.exception.ErrorCode
import nickname.maker.server.global.error.exception.MakerException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MakerException::class)
    fun handleMakerException(request: HttpServletRequest, ex: MakerException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(ex.errorCode)
        return ResponseEntity<ErrorResponse>(errorResponse, errorResponse.status)
    }


    @ExceptionHandler(Exception::class)
    fun handleException(
        e: Exception,
        request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)
    }
}