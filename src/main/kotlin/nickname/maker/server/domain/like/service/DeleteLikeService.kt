package nickname.maker.server.domain.like.service

import nickname.maker.server.domain.like.domain.Like
import nickname.maker.server.domain.like.domain.repository.LikeRepository
import nickname.maker.server.domain.like.facade.LikeFacade
import nickname.maker.server.domain.user.domain.User
import nickname.maker.server.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class DeleteLikeService(
    private val userFacade: UserFacade,
    private val likeRepository: LikeRepository,
    private val likeFacade: LikeFacade
) {
    fun execute(id: Long) {
        val user: User = userFacade.getCurrentUser()
        val like: Like = likeFacade.findByUserAndId(user, id)
        likeRepository.delete(like)
    }
}