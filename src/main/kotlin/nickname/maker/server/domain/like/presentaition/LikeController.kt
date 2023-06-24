package nickname.maker.server.domain.like.presentaition

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import nickname.maker.server.domain.like.service.CreateLikeService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/like")
@Tag(name = "좋아요 서버")
class LikeController(
    private val createLikeService: CreateLikeService
) {
    @Operation(summary = "좋아요 생성")
    @PostMapping("{sentence}")
    fun createLike(@PathVariable sentence: String) {
        createLikeService.execute(sentence)
    }

}