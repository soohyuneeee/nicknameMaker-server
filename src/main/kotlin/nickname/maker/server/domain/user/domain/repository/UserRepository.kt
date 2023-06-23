package nickname.maker.server.domain.user.domain.repository

import nickname.maker.server.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>{
    fun findUserByUserId(userId: String): User?
    fun existsUserByUserId(userId: String?): Boolean
}
