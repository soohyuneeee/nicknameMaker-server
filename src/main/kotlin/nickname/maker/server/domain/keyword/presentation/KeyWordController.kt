package nickname.maker.server.domain.keyword.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import nickname.maker.server.domain.keyword.presentation.dto.response.MyKeyWordResponse
import nickname.maker.server.domain.keyword.service.CreateKeyWordService
import nickname.maker.server.domain.keyword.service.GetKeyWordService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/keyword")
@Tag(name = "키워드 서버")
class KeyWordController(
    private val createKeyWordService: CreateKeyWordService,
    private val getKeyWordService: GetKeyWordService
) {
    @Operation(summary = "키워드 생성")
    @PostMapping("/{keyword}")
    fun createKeyWord(@PathVariable keyword: String) {
        createKeyWordService.execute(keyword)
    }

    @Operation(summary = "키워드 조회")
    @GetMapping
    fun getKeyWord() :MyKeyWordResponse{
        return getKeyWordService.execute()
    }
}