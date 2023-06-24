package nickname.maker.server.domain.like.domain.repository

import nickname.maker.server.domain.like.domain.Like
import nickname.maker.server.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository : JpaRepository<Like, Long> {
    fun existsLikeBySentenceAndUser(sentence: String, user: User): Boolean
    fun findByUserAndId(user: User, id: Long): Like?
    fun findAllByUser(user: User): List<Like>
}