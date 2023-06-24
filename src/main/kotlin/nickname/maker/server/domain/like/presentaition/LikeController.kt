package nickname.maker.server.domain.like.presentaition

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import nickname.maker.server.domain.like.presentaition.dto.response.LikeListResponse
import nickname.maker.server.domain.like.service.CreateLikeService
import nickname.maker.server.domain.like.service.DeleteLikeService
import nickname.maker.server.domain.like.service.GetMyLikeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/like")
@Tag(name = "좋아요 서버")
class LikeController(
    private val createLikeService: CreateLikeService,
    private val deleteLikeService: DeleteLikeService,
    private val getMyLikeService: GetMyLikeService
) {
    @Operation(summary = "좋아요 생성")
    @PostMapping("/{sentence}")
    fun createLike(@PathVariable sentence: String) {
        createLikeService.execute(sentence)
    }

    @Operation(summary = "좋아요 삭제")
    @DeleteMapping("/{id}")
    fun deleteLike(@PathVariable id: Long) {
        deleteLikeService.execute(id)
    }

    @Operation(summary = "좋아요 조회")
    @GetMapping("/my")
    fun geMytLike(): LikeListResponse {
        return getMyLikeService.execute()
    }

    @Operation(summary = "사람들의 좋아요 조회")
    @GetMapping
    fun getLike(): LikeListResponse {
        return getMyLikeService.execute()
    }

}