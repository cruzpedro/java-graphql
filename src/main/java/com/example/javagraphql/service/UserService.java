package com.example.javagraphql.service;

import com.example.javagraphql.model.User;
import com.example.javagraphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return this.repository.findAll();
    }

    public Optional<User> getUser(int id) {
        return this.repository.findById(id);
    }

    public List<User> findAll(int first, int last) {
        if ((last == 0) || (last < first)) {
            last = (int) this.repository.count();
        }

        List<User> userList = repository.findAll();
        return userList;

        /*return this.repository.findAllById(
            IntStream.rangeClosed(first, last).boxed().collect(Collectors.toList())
        );*/
    }

    public User save(String login, String name) {
        return this.repository.save(new User(login, name));
    }

    public User save(User user) {
        return this.repository.save(user);
    }

    public void delete(int id) {
        this.repository.deleteById(id);
    }

}
