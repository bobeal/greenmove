package fr.greensaver.search.model.es

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(indexName = "topic", type = "article")
class Article(
        @Id
        val id: String = UUID.randomUUID().toString(),
        val title: String,
        val description: String,
        val topic: String,
        val link: String,
        val img: String,
        val tree: Int)
