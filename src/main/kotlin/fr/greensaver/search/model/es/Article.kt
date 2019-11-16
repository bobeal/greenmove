package fr.greensaver.search.model.es

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document


@Document(indexName = "topic", type = "article")
class Article (
    @Id
    val id: String,
    val title: String,
    val description: String,
    val topic: String,
    val tree: Int)
