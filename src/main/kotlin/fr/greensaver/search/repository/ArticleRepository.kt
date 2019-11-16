package fr.greensaver.search.repository

import fr.greensaver.search.model.Article
import fr.greensaver.search.model.Profile
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : Neo4jRepository<Article, String>