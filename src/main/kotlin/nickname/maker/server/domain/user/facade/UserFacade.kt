package nickname.maker.server.domain.user.facade

import jakarta.transaction.Transactional
import nickname.maker.server.domain.user.domain.User
import nickname.maker.server.domain.user.domain.repository.UserRepository
import nickname.maker.server.domain.user.exception.UserAlreadyExistsException
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
            ?: throw UserNotFoundException()
    }

    @Transactional
    fun getCurrentUser(): User? {
        val auth = SecurityContextHolder.getContext().authentication.principal as AuthDetails
        return auth.user
    }

    @Transactional
    fun checkUserId(email: String?) {
        if (userRepository.existsUserByEmail(email)) throw UserAlreadyExistsException()
    }
}