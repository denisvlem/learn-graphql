package com.denisvlem.learngraphql.mapper.mappers;

import com.denisvlem.learngraphql.domain.BookDocument;
import com.denisvlem.learngraphql.entity.Book;
import com.denisvlem.learngraphql.mapper.CentralConfig;
import org.mapstruct.Mapper;

@Mapper(config = CentralConfig.class)
public interface BookMapper {
        Book toBook(BookDocument document);
}
