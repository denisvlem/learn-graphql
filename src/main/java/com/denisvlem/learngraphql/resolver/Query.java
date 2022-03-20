package com.denisvlem.learngraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.denisvlem.learngraphql.domain.BookDocument;
import com.denisvlem.learngraphql.entity.Book;
import com.denisvlem.learngraphql.entity.Genre;
import com.denisvlem.learngraphql.mapper.mappers.BookMapper;
import com.denisvlem.learngraphql.repository.elastic.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Book book(String id) {
        log.info("Retrieving book with id: {}", id);
        return bookMapper.toBook(
                bookRepository.findById(id).orElse(
                        BookDocument.builder()
                                .id("-1")
                                .genre(Genre.OTHER)
                                .title("John Doe").build())
        );
    }
}
