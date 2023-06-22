package nickname.maker.server.domain.user.service

import jakarta.transaction.Transactional
import nickname.maker.server.domain.user.domain.User
import nickname.maker.server.domain.user.domain.repository.UserRepository
import nickname.maker.server.domain.user.facade.UserFacade
import nickname.maker.server.domain.user.presentation.dto.request.SignupRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignupService(
    private val userFacade: UserFacade,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: SignupRequest) {
        userFacade.checkUserId(request.userId)
        userRepository.save(
            User(
                email = request.userId,
                password = passwordEncoder.encode(request.password),
                nickname = request.nickname
            )
        )
    }
}