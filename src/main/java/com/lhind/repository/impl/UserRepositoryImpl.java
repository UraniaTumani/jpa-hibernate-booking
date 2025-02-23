package com.lhind.repository.impl;

import com.lhind.model.entity.User;
import com.lhind.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public Optional<User> findById(Integer id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }


    @Override
    public List<User> findAllNamedQuery(String name) {
        return users.stream()
                .filter(u -> u.getUsername().contains(name) || u.getUsername().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
