package com.denisvlem.learngraphql.configuration;

import com.denisvlem.learngraphql.resolver.BookResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public BookResolver bookResolver() {
        return new BookResolver();
    }
}
