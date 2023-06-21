package nickname.maker.server.domain.auth.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import nickname.maker.server.domain.auth.presentation.dto.response.AccessTokenResponse
import nickname.maker.server.domain.auth.service.RefreshTokenService
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
@Tag(name = "인증 서버")
class AuthController(private val refreshTokenService: RefreshTokenService) {

    @Operation(summary = "토큰 재발급")
    @PutMapping
    fun refreshToken(@RequestHeader("Refresh-Token") refreshToken: String): AccessTokenResponse {
        return refreshTokenService.execute(refreshToken)
    }
}
