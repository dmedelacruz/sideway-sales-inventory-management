package com.sideway.management.configuration;

import com.sideway.management.exception.GraphQLErrorAdapter;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.stream.Collectors;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return errors -> errors.stream().map(GraphQLErrorAdapter::new).collect(Collectors.toList());
    }
}
