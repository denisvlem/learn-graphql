package com.denisvlem.learngraphql.repository;

import com.denisvlem.learngraphql.domain.BookDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<BookDocument, Long> {
}
