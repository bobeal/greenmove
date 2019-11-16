package fr.greensaver.search.web

import fr.greensaver.search.repository.TopicRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class TopicHandler(
        private val topicRepository: TopicRepository
) {

    fun getAll(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(BodyInserters.fromValue(topicRepository.findAll()))
    }
}
