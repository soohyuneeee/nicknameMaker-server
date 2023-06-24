package nickname.maker.server.domain.like.presentaition.dto.response

import java.time.LocalDateTime

data class LikeResponse(
    val id: Long?,
    val sentence: String,
    val createdAt: LocalDateTime?,
    val author: String?
)
