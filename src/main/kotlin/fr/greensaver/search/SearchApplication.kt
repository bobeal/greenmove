package fr.greensaver.search

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import fr.greensaver.search.model.es.Article
import fr.greensaver.search.model.neo4j.Topic
import fr.greensaver.search.repository.es.ArticleESRepository
import fr.greensaver.search.repository.neo4j.TopicRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File

@SpringBootApplication
class SearchApplication(private val topicRepository: TopicRepository, private val articleESRepository: ArticleESRepository) : CommandLineRunner {

    override fun run(vararg args: String) {
        topicRepository.findAll().toList().ifEmpty {
            listOf("Domestique", "Mobilité", "Alimentation", "Consommables", "Seconde Vie")
                    .forEach {
                        topicRepository.save(Topic(name = it))
                    }

        }

        articleESRepository.findAll().toList().ifEmpty {
            val mapper = jacksonObjectMapper()
            mapper.readValue<List<Article>>(File("./src/main/resources/articles.json")).forEach {
                articleESRepository.save(it)
            }
        }


    }
}

fun main(args: Array<String>) {
    runApplication<SearchApplication>(*args)
}
