package com.denisvlem.learngraphql.entity;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class Book {
    private String id;
    private String title;
    private Genre genre;
}
