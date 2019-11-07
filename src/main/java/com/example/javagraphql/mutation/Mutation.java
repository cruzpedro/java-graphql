package com.example.javagraphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.javagraphql.model.User;
import com.example.javagraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private UserService service;

    public User createUser(String login, String name) {
        return this.service.save(login, name);
    }

}
