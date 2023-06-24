package nickname.maker.server.domain.like.service

import nickname.maker.server.domain.like.domain.Like
import nickname.maker.server.domain.like.domain.repository.LikeRepository
import nickname.maker.server.domain.like.presentaition.dto.response.LikeResponse
import nickname.maker.server.domain.like.presentaition.dto.response.LikeListResponse
import nickname.maker.server.domain.user.domain.User
import nickname.maker.server.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class GetMyLikeService(
    private val userFacade: UserFacade,
    private val likeRepository: LikeRepository
) {
    fun execute(): LikeListResponse {
        val user: User = userFacade.getCurrentUser()
        val likes: List<Like> = likeRepository.findAllByUser(user)
        return LikeListResponse(
            LikeList = likes.map { like ->
                LikeResponse(
                    id = like.id,
                    sentence = like.sentence,
                    createdAt = like.createdAt,
                    author = user.nickname
                )
            }
        )
    }
}