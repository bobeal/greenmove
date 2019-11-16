package fr.greensaver.search.repository

import fr.greensaver.search.model.Topic
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : Neo4jRepository<Topic, String>
