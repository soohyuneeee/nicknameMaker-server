package nickname.maker.server.domain.like.facade

import jakarta.transaction.Transactional
import nickname.maker.server.domain.like.domain.repository.LikeRepository
import nickname.maker.server.domain.like.exception.LikeAlreadyExistsException
import nickname.maker.server.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class LikeFacade(
    val likeRepository: LikeRepository
) {
    @Transactional
    fun existsLikeBySentenceAndUser(sentence: String, user: User) {
        if (likeRepository.existsLikeBySentenceAndUser(sentence, user))
            throw LikeAlreadyExistsException()
    }
}