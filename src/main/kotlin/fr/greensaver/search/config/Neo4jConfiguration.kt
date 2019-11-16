package fr.greensaver.search.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager
import org.neo4j.ogm.session.SessionFactory
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean


@Configuration
@EnableNeo4jRepositories(basePackages = ["fr.greensaver.search.repository"])
@EntityScan(basePackages = ["fr.greensaver.search.model"])
class Neo4jConfiguration {

    @Bean
    fun sessionFactory(): SessionFactory {
        return SessionFactory(configuration(), "fr.greensaver.search.model")
    }

    @Bean
    fun configuration(): org.neo4j.ogm.config.Configuration {
        return org.neo4j.ogm.config.Configuration.Builder().credentials("neo4j", "test")
                .uri("bolt://localhost:7687").build()
    }

    @Bean
    fun transactionManager(): Neo4jTransactionManager {
        return Neo4jTransactionManager(sessionFactory())
    }

}
