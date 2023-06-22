package nickname.maker.server.domain.auth.service

import jakarta.transaction.Transactional
import nickname.maker.server.domain.auth.domain.RefreshToken
import nickname.maker.server.domain.auth.domain.repository.RefreshTokenRepository
import nickname.maker.server.domain.auth.presentation.dto.response.AccessTokenResponse
import nickname.maker.server.global.security.jwt.JwtTokenProvider
import nickname.maker.server.global.security.jwt.exception.ExpiredTokenException
import org.springframework.stereotype.Service

@Service
class RefreshTokenService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun execute(token: String): AccessTokenResponse {
        val refreshToken = getRefreshToken(token)
        val accessToken = jwtTokenProvider.createAccessToken(refreshToken.email)
        return AccessTokenResponse(accessToken)
    }

    @Transactional
    private fun getRefreshToken(token: String): RefreshToken {
        return refreshTokenRepository.findById(token)
            .orElseThrow { ExpiredTokenException.EXCEPTION }
    }
}
