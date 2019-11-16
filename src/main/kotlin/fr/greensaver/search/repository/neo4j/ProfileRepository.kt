package fr.greensaver.search.repository.neo4j

import fr.greensaver.search.model.neo4j.Profile
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfileRepository : Neo4jRepository<Profile, String> {

    @Query("MATCH (n { uuid:{0} }) return n.totalTreesWon" )
    fun treesWon(profileUuid: String): Int
}
