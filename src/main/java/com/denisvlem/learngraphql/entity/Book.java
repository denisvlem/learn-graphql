package com.denisvlem.learngraphql.entity;

import lombok.Builder;
import lombok.Setter;

import java.util.UUID;

@Setter
@Builder
public class Book {
    private UUID id;
    private String name;
    private Genre genre;
}
