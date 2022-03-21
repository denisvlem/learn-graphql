package com.denisvlem.learngraphql.repository.elastic;

import com.denisvlem.learngraphql.domain.BookDocument;
import com.denisvlem.learngraphql.entity.Genre;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface BookRepository extends ElasticsearchRepository<BookDocument, String> {

    List<BookDocument> findBookDocumentsByGenre(Genre genre);
}
