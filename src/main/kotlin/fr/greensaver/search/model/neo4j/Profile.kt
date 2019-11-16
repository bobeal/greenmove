package fr.greensaver.search.model.neo4j

import org.neo4j.ogm.annotation.*
import java.time.Instant
import java.util.*
import kotlin.collections.ArrayList

@NodeEntity
class Profile(
        @Id var uuid: String = UUID.randomUUID().toString(),
        @Property(name = "livesInUrbanArea") var livesInUrbanArea: Boolean,
        @Property(name = "retired") var retired: Boolean,
        @Property(name = "hasChild") var hasChild: Boolean,
        @Property(name = "livesInHouse") var livesInHouse: Boolean,
        @Property(name = "preferredMeansOfTransport") var preferredMeansOfTransport: String,
        @Property(name = "postalCode") var postalCode: String,
        var totalTreesWon: Int = 0,
        @Relationship(type = "INTERESTED_IN", direction = Relationship.OUTGOING) var topics: ArrayList<Topic> = arrayListOf(),
        @Relationship(type = "HAS_READ", direction = Relationship.OUTGOING) var readArticles: ArrayList<ReadArticle> = arrayListOf()
) {
    fun addTopic(topic: Topic) = this.topics.add(topic)

    fun addReadArticle(readArticle: ReadArticle, treesReward: Int) {
        this.readArticles.add(readArticle)
        this.totalTreesWon += treesReward
    }
}

@RelationshipEntity(type = "HAS_READ")
class ReadArticle(
        @Id var uuid: String = UUID.randomUUID().toString(),
        @Property var readAt: Instant,
        @StartNode var profile: Profile,
        @EndNode var article: Article
)

enum class MeansOfTransport {
    CAR,
    BIKE,
    PUBLIC_TRANSPORT
}
