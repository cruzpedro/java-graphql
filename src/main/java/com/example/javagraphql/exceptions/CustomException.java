package com.example.javagraphql.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomException extends RuntimeException implements GraphQLError {

    private final int errorCode;

    public CustomException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> customAttributes = new LinkedHashMap<>();
        customAttributes.put("statusCode", this.errorCode);
        customAttributes.put("message", this.getMessage());

        return customAttributes;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

}
