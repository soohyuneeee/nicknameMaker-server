package nickname.maker.server.global.security.jwt.filter

import io.jsonwebtoken.ExpiredJwtException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import nickname.maker.server.global.security.auth.AuthDetailsService
import nickname.maker.server.global.security.jwt.JwtTokenProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthenticationFilter(
        private val authDetailsService: AuthDetailsService,
        private val jwtTokenProvider: JwtTokenProvider,
): OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val accessToken = jwtTokenProvider.resolveToken(request)
        if (accessToken != null) setAuthentication(accessToken, request)

        filterChain.doFilter(request, response)
    }

    @Throws(ExpiredJwtException::class)
    private fun setAuthentication(token: String, request: HttpServletRequest) {
        val userDetails = authDetailsService.loadUserByUsername(jwtTokenProvider.getEmail(token))
        val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
        SecurityContextHolder.getContext().authentication = authentication
    }

}