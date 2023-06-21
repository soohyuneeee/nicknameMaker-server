package nickname.maker.server.global.security.jwt.filter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import nickname.maker.server.global.error.ErrorResponse
import nickname.maker.server.global.error.exception.MakerException
import org.springframework.http.HttpStatus
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

class JwtExceptionFilter(
        private val mapper: ObjectMapper
) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, chain: FilterChain) {
        try {
            chain.doFilter(req, res) // go to 'JwtAuthenticationFilter'
        } catch (e: MakerException) {
            setErrorResponse(res, e)
        }
    }

    @Throws(IOException::class)
    fun setErrorResponse(res: HttpServletResponse, e: MakerException) {
        res.status = HttpStatus.UNAUTHORIZED.value()
        res.contentType = "application/json; charset=UTF-8"
        val errorResponse: ErrorResponse = ErrorResponse(
                status = e.errorCode.status,
                message = e.errorCode.message
        )
        res.writer.write(mapper.writeValueAsString(errorResponse))
    }
}