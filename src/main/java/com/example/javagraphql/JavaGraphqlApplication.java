package com.example.javagraphql;

import com.example.javagraphql.exceptions.CustomExceptionHandler;
import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.AsyncSerialExecutionStrategy;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGraphqlApplication.class, args);
	}

	@Bean
	public GraphQL graphQL(GraphQLSchema schema) {
		return GraphQL.newGraphQL(schema)
				.queryExecutionStrategy(new AsyncExecutionStrategy(new CustomExceptionHandler()))
				.mutationExecutionStrategy(new AsyncSerialExecutionStrategy(new CustomExceptionHandler()))
				.build();
	}

}
