package fr.greensaver.search.model.neo4j

import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import java.util.*

@NodeEntity
class Article(
        @Id var uuid: String = UUID.randomUUID().toString(),
        var reference: String,
        var treesReward: Int
)
