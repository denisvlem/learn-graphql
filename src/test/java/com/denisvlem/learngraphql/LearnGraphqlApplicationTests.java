package com.denisvlem.learngraphql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class LearnGraphqlApplicationTests extends BaseItTest{

    @Autowired
    private LearnGraphqlApplication context;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(context);
    }
}
