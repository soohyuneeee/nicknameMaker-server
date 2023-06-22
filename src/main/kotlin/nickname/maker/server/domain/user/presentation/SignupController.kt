package nickname.maker.server.domain.user.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import nickname.maker.server.domain.user.presentation.dto.request.SignupRequest
import nickname.maker.server.domain.user.service.SignupService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/signup")
@Tag(name = "회원가입 서버")
class SignupController(
    private val signupService: SignupService
) {
    @Operation(summary = "회원가입")
    @PostMapping
    fun signup(@RequestBody request: SignupRequest) {
        signupService.execute(request)
    }
}