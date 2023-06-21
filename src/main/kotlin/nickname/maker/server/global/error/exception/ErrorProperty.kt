package nickname.maker.server.global.error.exception

import org.springframework.http.HttpStatus

interface ErrorProperty {
    fun getStatus(): HttpStatus
    fun getMessage(): String
}