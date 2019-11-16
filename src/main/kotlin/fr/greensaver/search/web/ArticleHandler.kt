package fr.greensaver.search.web

import fr.greensaver.search.service.ArticleService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class ArticleHandler(val articleService: ArticleService) {

    fun searchByTopic(request: ServerRequest): Mono<ServerResponse> {
        return Mono.just(request.pathVariable("topic"))
                .map {
                    articleService.searchByTopic(it)
                }
                .flatMap {
                    ServerResponse.ok().body(BodyInserters.fromValue(it))
                }
    }
}