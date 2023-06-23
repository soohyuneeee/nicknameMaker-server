package nickname.maker.server.domain.auth.service

import jakarta.transaction.Transactional
import nickname.maker.server.domain.auth.presentation.dto.request.LoginRequest
import nickname.maker.server.domain.auth.presentation.dto.response.TokenResponse
import nickname.maker.server.domain.user.exception.PasswordMismatchException
import nickname.maker.server.domain.user.facade.UserFacade
import nickname.maker.server.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val userFacade: UserFacade,
    private val jwtTokenProvider: JwtTokenProvider,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: LoginRequest): TokenResponse {
        val user = userFacade.findUserByUserId(request.userId)
        checkPassword(request.password, user.password)
        return TokenResponse(
            jwtTokenProvider.createAccessToken(user.userId),
            jwtTokenProvider.createRefreshToken(user.userId),
            user.userId,
            user.nickname
        )

    }

    fun checkPassword(password: String, encodedPassword: String) {
        if (!passwordEncoder.matches(password, encodedPassword)) {
            throw PasswordMismatchException()
        }
    }
}