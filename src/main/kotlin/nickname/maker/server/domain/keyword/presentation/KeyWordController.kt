package nickname.maker.server.domain.keyword.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import nickname.maker.server.domain.keyword.service.CreateKeyWordService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/keyword")
@Tag(name = "키워드 서버")
class KeyWordController(
    private val createKeyWordService: CreateKeyWordService
) {
    @Operation(summary = "키워드 생성")
    @PostMapping("/{keyword}")
    fun createKeyWord(@PathVariable keyword: String) {
        createKeyWordService.execute(keyword)
    }
}