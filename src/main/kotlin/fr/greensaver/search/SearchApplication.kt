package fr.greensaver.search

import fr.greensaver.search.model.Topic
import fr.greensaver.search.repository.TopicRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SearchApplication(private val topicRepository: TopicRepository) : CommandLineRunner {

	override fun run(vararg args: String) {
		listOf("Domestique", "Mobilité", "Alimentation", "Consommables", "Seconde Vie")
				.forEach {
					topicRepository.save(Topic(name = it))
				}
	}
}

fun main(args: Array<String>) {
	runApplication<SearchApplication>(*args)
}
