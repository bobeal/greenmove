package fr.greensaver.search.repository.neo4j

import fr.greensaver.search.model.neo4j.Article
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ArticleRepository : Neo4jRepository<Article, String> {

    fun findByReference(reference: String): Optional<Article>
}
