package com.lhind.service;

import com.lhind.model.entity.User;
import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> loadAllUsers();
    List<User> findAllNamedQuery(String username);
}
