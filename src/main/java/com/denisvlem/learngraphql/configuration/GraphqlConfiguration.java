package com.denisvlem.learngraphql.configuration;

import com.denisvlem.learngraphql.resolver.BookResolver;
import com.denisvlem.learngraphql.resolver.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public Query query() {
        return new Query();
    }

    @Bean
    public BookResolver bookResolver() {
        return new BookResolver();
    }
}
