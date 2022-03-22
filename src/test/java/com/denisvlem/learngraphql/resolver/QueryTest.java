package com.denisvlem.learngraphql.resolver;

import com.denisvlem.learngraphql.BaseItTest;
import com.denisvlem.learngraphql.commons.GraphqlQueryDto;
import com.denisvlem.learngraphql.domain.BookDocument;
import com.denisvlem.learngraphql.entity.Book;
import com.denisvlem.learngraphql.entity.Genre;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryTest extends BaseItTest {

    @Test
    void givenEmptyBody_whenGraphqlRequest_thenReturnBadParams() {
        given().when().post(GRAPHQL_URL).then().statusCode(400);
    }

    @Test
    void givenEmptyIndex_whenGetBooksByGenre_thenReturnEmptyList() {

        //given
        var query = new GraphqlQueryDto();
        query.setQuery(getBooksByGenreRequest(Genre.OTHER));

        //when
        List<Book> response = given().body(query).when().post(GRAPHQL_URL)

                //then
                .then().statusCode(200)
                .extract().jsonPath().getList("data.booksByGenre", Book.class);
        assertEquals(0, response.size());
    }

    @Test
    void givenOneDetectiveBook_whenGetBooksByGenreDetective_thenReturnOneElementList() {

        //given
        var doc = BookDocument.builder()
                .id("testId")
                .title("testTitle")
                .genre(Genre.DETECTIVE).build();

        Mockito.doReturn(List.of(doc))
                .when(bookRepository).findBookDocumentsByGenre(Genre.DETECTIVE);

        var query = new GraphqlQueryDto();
        query.setQuery(getBooksByGenreRequest(Genre.DETECTIVE));

        //when
        var response = given().body(query).when().post(GRAPHQL_URL)

                //then
                .then().statusCode(200)
                .extract().jsonPath().getList("data.booksByGenre", Book.class);
        assertEquals(1, response.size());

        assertEquals(doc.getId(), response.get(0).getId());
        assertEquals(doc.getTitle(), response.get(0).getTitle());
        assertEquals(doc.getGenre(), response.get(0).getGenre());
    }

    private String getBooksByGenreRequest(Genre genre) {
        return String.format("query{\nbooksByGenre(genre: %s){\nid\ngenre\ntitle\n}}", genre.toString());
    }

}