package nickname.maker.server.domain.auth.presentation.dto.request

data class LoginRequest(
    val userId: String,
    val password: String
)