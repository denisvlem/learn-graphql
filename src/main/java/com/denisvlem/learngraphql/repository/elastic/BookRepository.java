package com.denisvlem.learngraphql.repository.elastic;

import com.denisvlem.learngraphql.domain.BookDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<BookDocument, String> {
}
