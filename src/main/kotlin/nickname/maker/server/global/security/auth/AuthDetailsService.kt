package nickname.maker.server.global.security.auth

import nickname.maker.server.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    val userFacade: UserFacade,
): UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        return AuthDetails(userFacade.findUserByEmail(email))
    }
}