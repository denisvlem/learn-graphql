package com.denisvlem.learngraphql.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String id;
    private String title;
    private Genre genre;
}
