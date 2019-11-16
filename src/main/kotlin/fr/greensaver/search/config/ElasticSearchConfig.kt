package fr.greensaver.search.config

import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.core.convert.support.DefaultConversionService
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper
import org.springframework.data.elasticsearch.core.EntityMapper


@Configuration
@EnableElasticsearchRepositories(
        basePackages = arrayOf("fr.greensaver.search.repository.es")
)
class ElasticSearchConfig : AbstractElasticsearchConfiguration() {

    @Value("\${application.es.url}")
    val esUrl: String? = null

    override fun elasticsearchClient(): RestHighLevelClient {
        return RestClients.create(ClientConfiguration.create(esUrl)).rest()
    }

    @Bean
    override fun entityMapper(): EntityMapper {

        val entityMapper = ElasticsearchEntityMapper(
                elasticsearchMappingContext(), DefaultConversionService()
        )
        entityMapper.setConversions(elasticsearchCustomConversions())

        return entityMapper
    }
}
