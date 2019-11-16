package fr.greensaver.search.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes(
        private val profileHandler: ProfileHandler,
        private val topicHandler: TopicHandler,
        private val articleHandler: ArticleHandler
) {

    @Bean
    fun router() = router {
        (accept(MediaType.valueOf("application/json")) and "/api")
                .nest {
                    "/profile".nest {
                        POST("", profileHandler::create)
                        GET("", profileHandler::getAll)
                        GET("/{id}", profileHandler::getById)
                        POST("/{id}/topic/{topicId}", profileHandler::addTopic)
                        POST("/{id}/article/{articleReference}", profileHandler::addArticle)
                        GET("/{id}/treesWon", profileHandler::treesWon)
                    }
                    "/topic".nest {
                        GET("", topicHandler::getAll)
                    }
                    "/article".nest {
                        GET("", articleHandler::searchByTopic)
                    }
                }
    }
}
