package nickname.maker.server.domain.like.service

import jakarta.transaction.Transactional
import nickname.maker.server.domain.like.domain.Like
import nickname.maker.server.domain.like.domain.repository.LikeRepository
import nickname.maker.server.domain.like.facade.LikeFacade
import nickname.maker.server.domain.user.domain.User
import nickname.maker.server.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CreateLikeService(
    private val userFacade: UserFacade,
    private val likeRepository: LikeRepository,
    private val likeFacade: LikeFacade
) {
    @Transactional
    fun execute(sentence: String) {
        val user: User = userFacade.getCurrentUser()
        likeFacade.existsLikeBySentenceAndUser(sentence, user)
        likeRepository.save(
            Like(
                sentence = sentence,
                user = user
            )
        )
    }
}