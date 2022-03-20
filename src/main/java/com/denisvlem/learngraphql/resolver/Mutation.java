package com.denisvlem.learngraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.denisvlem.learngraphql.domain.BookDocument;
import com.denisvlem.learngraphql.entity.Book;
import com.denisvlem.learngraphql.entity.Genre;
import com.denisvlem.learngraphql.mapper.mappers.BookMapper;
import com.denisvlem.learngraphql.repository.elastic.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Book addBook(String title, Genre genre) {
        var toSave = BookDocument.builder()
                .title(title)
                .genre(null == genre ? Genre.OTHER : genre).build();
        var saved = bookRepository.save(toSave);
        return bookMapper.toBook(saved);
    }
}
