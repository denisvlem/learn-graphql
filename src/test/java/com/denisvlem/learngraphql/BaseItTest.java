package com.denisvlem.learngraphql;

import com.denisvlem.learngraphql.repository.elastic.BookRepository;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseItTest {

    public static String GRAPHQL_URL = "/graphql";

    @LocalServerPort
    protected int port;

    @MockBean
    protected BookRepository bookRepository;

    @BeforeEach
    public final void setUpEnv() {
        RestAssured.port = port;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setPort(port)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }
}
