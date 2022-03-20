package com.denisvlem.learngraphql.domain;

import com.denisvlem.learngraphql.entity.Genre;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "book")
@Builder
@Data
public class BookDocument {

    @Id
    private String id;

    private String title;

    private Genre genre;
}
