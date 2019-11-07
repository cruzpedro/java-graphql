package com.example.javagraphql.exceptions;

import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;

/*@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {
    @Override
    public boolean errorsPresent(List<GraphQLError> errors) {
        return !errors.isEmpty();
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list;
    }
}*/
