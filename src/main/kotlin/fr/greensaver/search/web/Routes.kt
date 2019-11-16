package fr.greensaver.search.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes(
        private val profileHandler: ProfileHandler
) {

    @Bean
    fun router() = router {
        (accept(MediaType.valueOf("application/json")) and "/api")
                .nest {
                    "/profile".nest {
                        POST("", profileHandler::create)
                        GET("/{id}", profileHandler::getById)
                    }
                }
    }
}
