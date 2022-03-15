package com.denisvlem.learngraphql.domain;

import com.denisvlem.learngraphql.entity.Genre;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "book")
@Builder
@Data
public class BookDocument {

    @Id
    private Long id;

    private String title;

    @Field
    private Genre genre;
}
