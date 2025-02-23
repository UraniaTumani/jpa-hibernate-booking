package com.lhind.repository;

import com.lhind.model.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Integer> {
    Optional<User> findByUsername(String username);
    List<User> findAllNamedQuery(String username);
}
