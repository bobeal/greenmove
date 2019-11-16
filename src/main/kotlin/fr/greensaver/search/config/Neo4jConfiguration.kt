package fr.greensaver.search.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager
import org.neo4j.ogm.session.SessionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean


@Configuration
@EnableNeo4jRepositories(basePackages = ["fr.greensaver.search.repository.neo4j"])
@EntityScan(basePackages = ["fr.greensaver.search.model.neo4j"])
class Neo4jConfiguration {

    @Value("\${spring.data.neo4j.uri}")
    val neo4jUrl: String? = null

    @Bean
    fun sessionFactory(): SessionFactory {
        return SessionFactory(configuration(), "fr.greensaver.search.model.neo4j")
    }

    @Bean
    fun configuration(): org.neo4j.ogm.config.Configuration {
        return org.neo4j.ogm.config.Configuration.Builder().credentials("neo4j", "test")
                .uri(neo4jUrl).build()
    }

    @Bean
    fun transactionManager(): Neo4jTransactionManager {
        return Neo4jTransactionManager(sessionFactory())
    }

}
