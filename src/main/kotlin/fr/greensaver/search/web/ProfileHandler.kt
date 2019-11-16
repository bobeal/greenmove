package fr.greensaver.search.web

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class ProfileHandler {

    fun create(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().build()
    }
}
