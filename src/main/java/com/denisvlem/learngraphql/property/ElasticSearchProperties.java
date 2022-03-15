package com.denisvlem.learngraphql.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.elasticsearch")
@Data
public class ElasticSearchProperties {

    private String host;
    private int port;

    public String getElasticAddress() {
        return host + ":" + port;
    }
}
