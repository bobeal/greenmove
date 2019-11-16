package fr.greensaver.search.web

import fr.greensaver.search.model.Profile
import fr.greensaver.search.repository.ProfileRepository
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

@Component
class ProfileHandler(
        private val profileRepository: ProfileRepository
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
}
