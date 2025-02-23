package com.lhind.repository;

import com.lhind.model.entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsRepository {
    Optional<UserDetails> findById(Integer id);
    List<UserDetails> findAll();
    void save(UserDetails userDetails);
    void delete(UserDetails userDetails);
    Optional<UserDetails> findByEmail(String email);

}
