package fr.greensaver.search.web

import fr.greensaver.search.model.Article
import fr.greensaver.search.model.Profile
import fr.greensaver.search.repository.ArticleRepository
import fr.greensaver.search.repository.ProfileRepository
import fr.greensaver.search.repository.TopicRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.created
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import java.net.URI
import java.time.Instant

@Component
class ProfileHandler(
        private val profileRepository: ProfileRepository,
        private val topicRepository: TopicRepository,
        private val articleRepository: ArticleRepository
) {

    fun create(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono<Profile>()
                .map {
                    profileRepository.save(it)
                }
                .flatMap {
                    created(URI("/profile/${it.uuid}")).build()
                }
                .onErrorResume {
                    ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                }
    }

    fun getById(req: ServerRequest): Mono<ServerResponse> {
        return Mono.just(req.pathVariable("id"))
                .map {
                    profileRepository.findById(it).orElseThrow()
                }
                .flatMap {
                    ok().body(BodyInserters.fromValue(it))
                }
    }

    fun addTopic(req: ServerRequest): Mono<ServerResponse> {
        return Mono.just(req.pathVariable("topicId"))
                .map {
                    topicRepository.findById(it).orElseThrow()
                }
                .map {
                    profileRepository.findById(req.pathVariable("id")).map { profile ->
                        profile.addTopic(it)
                        profile
                    }.orElseThrow()
                }
                .map {
                    profileRepository.save(it)
                }
                .flatMap {
                    ok().build()
                }
    }

    fun addArticle(req: ServerRequest): Mono<ServerResponse> {
        return Mono.just(req.pathVariable("articleReference"))
                .map {
                    articleRepository.findById(it).orElseGet {
                        articleRepository.save(Article(reference = it, readAt = Instant.now(), treesWon = 1))
                    }
                }
                .map {
                    profileRepository.findById(req.pathVariable("id")).map { profile ->
                        profile.addReadArticle(it)
                        profile
                    }.orElseThrow()
                }
                .map {
                    profileRepository.save(it)
                }
                .flatMap {
                    ok().build()
                }
    }

    fun treesWon(req: ServerRequest): Mono<ServerResponse> {
        return ok().body(BodyInserters.fromValue(profileRepository.treesWon(req.pathVariable("id"))))
    }
}
