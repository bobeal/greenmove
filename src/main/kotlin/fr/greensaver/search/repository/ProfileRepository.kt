package fr.greensaver.search.repository

import fr.greensaver.search.model.Profile
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfileRepository : Neo4jRepository<Profile, String> {

    @Query("MATCH (n { uuid:{0} })-[HAS_READ]->(a) return sum(a.treesWon)" )
    fun treesWon(profileUuid: String): Int
}
