package fr.greensaver.search.model

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import java.util.*

@NodeEntity
class Profile(
        @Id var uuid: String = UUID.randomUUID().toString(),
        @Property(name = "livesInUrbanArea") var livesInUrbanArea: Boolean,
        @Property(name = "retired") var retired: Boolean,
        @Property(name = "hasChild") var hasChild: Boolean,
        @Property(name = "livesInHouse") var livesInHouse: Boolean,
        @Property(name = "preferredMeansOfTransport") var preferredMeansOfTransport: String,
        @Property(name = "postalCode") var postalCode: String
)

enum class MeansOfTransport {
    CAR,
    BIKE,
    PUBLIC_TRANSPORT
}
