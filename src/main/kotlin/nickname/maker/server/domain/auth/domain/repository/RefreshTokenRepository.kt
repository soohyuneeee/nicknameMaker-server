package nickname.maker.server.domain.auth.domain.repository

import nickname.maker.server.domain.auth.domain.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository

interface RefreshTokenRepository : JpaRepository<RefreshToken, String> {
    fun findByToken(token: String): RefreshToken?
    fun deleteByToken(token: String)
}