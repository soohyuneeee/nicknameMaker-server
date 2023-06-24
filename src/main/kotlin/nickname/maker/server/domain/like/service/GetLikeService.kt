package nickname.maker.server.domain.like.service

import nickname.maker.server.domain.like.domain.repository.LikeRepository
import nickname.maker.server.domain.like.presentaition.dto.response.LikeListResponse
import nickname.maker.server.domain.like.presentaition.dto.response.LikeResponse
import org.springframework.stereotype.Service

@Service
class GetLikeService(
    private val likeRepository: LikeRepository
) {
    fun execute(): LikeListResponse {
        val likes = likeRepository.findAll()
        return LikeListResponse(
            LikeList = likes.map { like ->
                LikeResponse(
                    id = like.id,
                    sentence = like.sentence,
                    createdAt = like.createdAt,
                    author = like.user?.nickname
                )
            }
        )
    }
}