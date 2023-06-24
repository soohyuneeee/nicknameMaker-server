package nickname.maker.server.domain.keyword.service

import jakarta.transaction.Transactional
import nickname.maker.server.domain.keyword.domain.repository.KeyWordRepository
import nickname.maker.server.domain.keyword.presentation.dto.response.MyKeyWordResponse
import nickname.maker.server.domain.user.domain.User
import nickname.maker.server.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class GetKeyWordService(
    private val userFacade: UserFacade,
    private val keyWordRepository: KeyWordRepository
) {
    @Transactional
    fun execute(): MyKeyWordResponse {
        val user: User = userFacade.getCurrentUser()
        val keyWords = keyWordRepository.findAllByAuthor(user)
        return MyKeyWordResponse(
            keyWords = keyWords.map { it.word }
        )
    }
}