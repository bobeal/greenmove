package fr.greensaver.search.service

import fr.greensaver.search.model.es.Article
import fr.greensaver.search.repository.es.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(val articleRepository: ArticleRepository) {

    fun searchByTopic(topic: String) : List<Article> {
        return articleRepository.findAllByTopic(topic)
    }

    fun getArticleById(id: String): Article {
        return articleRepository.getArticleById(id)
    }
}
