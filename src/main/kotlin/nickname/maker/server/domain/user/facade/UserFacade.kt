package nickname.maker.server.domain.user.facade

import jakarta.transaction.Transactional
import nickname.maker.server.domain.user.domain.User
import nickname.maker.server.domain.user.domain.repository.UserRepository
import nickname.maker.server.domain.user.exception.UserNotFoundException
import nickname.maker.server.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    val userRepository: UserRepository,
) {
    @Transactional
    fun findUserByEmail(email: String): User {
        return userRepository.findUserByEmail(email)
            ?: throw UserNotFoundException.EXCEPTION
    }

    fun getCurrentUser(): User {
        val auth: AuthDetails = SecurityContextHolder.getContext().authentication.principal as AuthDetails
        return auth.user
    }
}