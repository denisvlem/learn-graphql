package com.denisvlem.learngraphql.configuration;

import com.denisvlem.learngraphql.mapper.mappers.BookMapper;
import com.denisvlem.learngraphql.repository.elastic.BookRepository;
import com.denisvlem.learngraphql.resolver.BookResolver;
import com.denisvlem.learngraphql.resolver.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public Query query(BookRepository bookRepository, BookMapper bookMapper) {
        return new Query(bookRepository, bookMapper);
    }

    @Bean
    public BookResolver bookResolver() {
        return new BookResolver();
    }
}
