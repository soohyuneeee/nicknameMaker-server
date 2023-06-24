package nickname.maker.server.domain.keyword.domain.repository

import nickname.maker.server.domain.keyword.domain.KeyWord
import nickname.maker.server.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface KeyWordRepository : JpaRepository<KeyWord, Long>{
    fun findKeyWordByWord(word: String): KeyWord?
    fun findAllByAuthor(author: User) : List<KeyWord>
}