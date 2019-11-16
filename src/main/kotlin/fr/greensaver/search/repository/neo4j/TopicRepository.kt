package fr.greensaver.search.repository.neo4j

import fr.greensaver.search.model.neo4j.Topic
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : Neo4jRepository<Topic, String>
