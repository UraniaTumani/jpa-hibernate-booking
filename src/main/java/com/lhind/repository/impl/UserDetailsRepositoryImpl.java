package com.lhind.repository.impl;

import com.lhind.model.entity.UserDetails;
import com.lhind.repository.UserDetailsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDetailsRepositoryImpl implements UserDetailsRepository {
    @PersistenceContext
    private EntityManager entityManager; // ✅ Inject EntityManager

    @Transactional
    public void save(UserDetails userDetails) {
        entityManager.persist(userDetails); // ✅ Now this works
    }
    private List<UserDetails> userDetailsList = new ArrayList<>();

    @Override
    public Optional<UserDetails> findById(Integer id) {
        return userDetailsList.stream().filter(ud -> ud.getId().equals(id)).findFirst();
    }

    @Override
    public List<UserDetails> findAll() {
        return new ArrayList<>(userDetailsList);
    }

    @Override
    public void delete(UserDetails userDetails) {
        userDetailsList.remove(userDetails);
    }

    // ✅ Implementing `findByEmail`
    @Override
    public Optional<UserDetails> findByEmail(String email) {
        return userDetailsList.stream()
                .filter(ud -> ud.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}
