package nickname.maker.server.global.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
        val accessTokenValidTime: Long,
        val refreshTokenValidTime: Long,
        val prefix: String,
        val header: String,
        val secretKey: String,
)