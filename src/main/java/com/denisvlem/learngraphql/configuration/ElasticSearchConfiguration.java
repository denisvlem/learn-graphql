package com.denisvlem.learngraphql.configuration;

import com.denisvlem.learngraphql.property.ElasticSearchProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.denisvlem.learngraphql.repository"})
@RequiredArgsConstructor
@Slf4j
public class ElasticSearchConfiguration {

    private final ElasticSearchProperties elasticSearchProperties;

    @Bean
    public RestHighLevelClient client() {
        var configuration = ClientConfiguration.builder()
                .connectedTo(elasticSearchProperties.getElasticAddress()).build();

        log.debug(String.format("Elastic search url: [%s]", elasticSearchProperties.getElasticAddress()));
        return RestClients.create(configuration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
