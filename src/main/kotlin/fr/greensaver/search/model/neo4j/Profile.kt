package fr.greensaver.search.model.neo4j

import org.neo4j.ogm.annotation.*
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
        @Relationship(type = "HAS_READ", direction = Relationship.OUTGOING) var readArticles: ArrayList<Article> = arrayListOf()
) {
    fun addTopic(topic: Topic) = this.topics.add(topic)

    fun addReadArticle(article: Article) {
        this.readArticles.add(article)
        this.totalTreesWon += article.treesReward
    }
}

enum class MeansOfTransport {
    CAR,
    BIKE,
    PUBLIC_TRANSPORT
}
