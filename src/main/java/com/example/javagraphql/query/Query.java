package com.example.javagraphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.javagraphql.exceptions.CustomException;
import com.example.javagraphql.model.User;
import com.example.javagraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private UserService service;

    public List<User> getUsers(int first, int last) {
        /*throw new CustomException(500, "Runtime Error");*/
        return service.findAll(first, last);
    }

    public Optional<User> getUser(int id) {
        return this.service.getUser(id);
    }

}
