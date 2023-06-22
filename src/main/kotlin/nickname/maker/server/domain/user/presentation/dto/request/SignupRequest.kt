package nickname.maker.server.domain.user.presentation.dto.request

data class SignupRequest (
    val userId: String,
    val password: String,
    val nickname: String
)
