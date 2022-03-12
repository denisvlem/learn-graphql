package com.denisvlem.learngraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.denisvlem.learngraphql.entity.Book;
import com.denisvlem.learngraphql.entity.Genre;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class Query implements GraphQLQueryResolver {

    public Book book(UUID id) {
        log.info("Retrieving book with id: {}", id);
        return Book.builder().id(id).name("Police").genre(Genre.DETECTIVE).build();
    }
}
