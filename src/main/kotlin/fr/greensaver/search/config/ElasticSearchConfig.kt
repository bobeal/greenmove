package fr.greensaver.search.config

import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories


@Configuration
@EnableElasticsearchRepositories(
        basePackages = arrayOf("fr.greensaver.search.repositories")
)
class ElasticSearchConfig : AbstractElasticsearchConfiguration() {

    override fun elasticsearchClient(): RestHighLevelClient {
        return RestClients.create(ClientConfiguration.create("localhost:9200")).rest()
    }
}
