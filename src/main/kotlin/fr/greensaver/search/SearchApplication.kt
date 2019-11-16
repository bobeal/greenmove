package fr.greensaver.search

import fr.greensaver.search.model.neo4j.Topic
import fr.greensaver.search.repository.neo4j.TopicRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SearchApplication(private val topicRepository: TopicRepository) : CommandLineRunner {

    override fun run(vararg args: String) {
        topicRepository.findAll().toList().ifEmpty {
            listOf("Domestique", "Mobilité", "Alimentation", "Consommables", "Seconde Vie")
                    .forEach {
                        topicRepository.save(Topic(name = it))
                    }

        }
    }
}

fun main(args: Array<String>) {
    runApplication<SearchApplication>(*args)
}
