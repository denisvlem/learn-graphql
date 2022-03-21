package com.denisvlem.learngraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.denisvlem.learngraphql.domain.BookDocument;
import com.denisvlem.learngraphql.entity.Book;
import com.denisvlem.learngraphql.entity.Genre;
import com.denisvlem.learngraphql.mapper.mappers.BookMapper;
import com.denisvlem.learngraphql.repository.elastic.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
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

    public List<Book> getBooksByGenre(Genre genre) {
        log.info("Retrieving books filtered by genre: {}", genre);
        var documentList = bookRepository.findBookDocumentsByGenre(genre);
        return bookMapper.toBookList(documentList);
    }

    public List<Book> getBooks() {
        log.info("Retrieving books");
        var documentList = bookRepository.findAll();
        return bookMapper.toBookList(documentList);
    }
}
