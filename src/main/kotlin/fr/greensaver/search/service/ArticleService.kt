package fr.greensaver.search.service

import fr.greensaver.search.model.es.Article
import fr.greensaver.search.repository.es.ArticleESRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(val articleESRepository: ArticleESRepository) {

    fun searchByTopic(topic: String) : List<Article> {
        return articleESRepository.findAllByTopic(topic)
    }

    fun getArticleById(id: String): Article {
        return articleESRepository.getArticleById(id)
    }
}
