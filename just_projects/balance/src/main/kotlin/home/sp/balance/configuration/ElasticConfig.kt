package home.sp.balance.configuration

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients

@Configuration
class ElasticConfig {

    @Bean
    fun client(): RestHighLevelClient {
        val clientConfig = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build()

        return RestClients.create(clientConfig).rest()
    }
}