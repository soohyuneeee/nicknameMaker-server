package nickname.maker.server.domain.auth.presentation.dto.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val userId: String,
    val nickname: String
)