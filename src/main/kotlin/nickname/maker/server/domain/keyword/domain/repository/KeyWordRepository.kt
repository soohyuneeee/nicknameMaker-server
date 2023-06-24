package nickname.maker.server.domain.keyword.domain.repository

import nickname.maker.server.domain.keyword.domain.KeyWord
import org.springframework.data.jpa.repository.JpaRepository

interface KeyWordRepository : JpaRepository<KeyWord, Long>{
}