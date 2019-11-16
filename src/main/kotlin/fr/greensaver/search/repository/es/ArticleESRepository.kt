package fr.greensaver.search.repository.es

import fr.greensaver.search.model.es.Article
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleESRepository : ElasticsearchRepository<Article, Long> {
    fun findAllByTopic(topic: String): List<Article>

    fun getArticleById(id: String): Article
}
