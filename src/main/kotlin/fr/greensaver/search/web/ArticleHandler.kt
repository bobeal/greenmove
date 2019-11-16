package fr.greensaver.search.web

import fr.greensaver.search.repository.es.ArticleESRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class ArticleHandler(private val articleESRepository: ArticleESRepository) {

    fun searchByTopic(request: ServerRequest): Mono<ServerResponse> {
        return Mono.just(request.queryParam("topic"))
                .map {
                    it.map { articleESRepository.findAllByTopic(it) }
                            .orElseGet { articleESRepository.findAll().toList() }
                }
                .flatMap {
                    ServerResponse.ok().body(BodyInserters.fromValue(it))
                }
    }
}
