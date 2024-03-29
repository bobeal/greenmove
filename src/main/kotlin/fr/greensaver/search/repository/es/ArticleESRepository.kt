package fr.greensaver.search.repository.es

import fr.greensaver.search.model.es.Article
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleESRepository : ElasticsearchRepository<Article, String> {
    fun findAllByTopic(topic: String): List<Article>
}
