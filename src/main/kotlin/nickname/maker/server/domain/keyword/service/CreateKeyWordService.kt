package nickname.maker.server.domain.keyword.service

import jakarta.transaction.Transactional
import nickname.maker.server.domain.keyword.domain.KeyWord
import nickname.maker.server.domain.keyword.domain.repository.KeyWordRepository
import nickname.maker.server.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CreateKeyWordService(
    private val userFacade: UserFacade,
    private val keyWordRepository: KeyWordRepository
) {
    @Transactional
    fun execute(keyWord: String) {
        val user = userFacade.getCurrentUser()
        keyWordRepository.save(
            KeyWord(
                word = keyWord,
                author = user
            )
        )
    }
}