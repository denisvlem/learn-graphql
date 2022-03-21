package com.denisvlem.learngraphql.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphqlQueryDto {
    private String query;
    private String variables;
}
