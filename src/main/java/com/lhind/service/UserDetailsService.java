package com.lhind.service;

import com.lhind.model.entity.UserDetails;
import com.lhind.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public List<UserDetails> getAllUserDetails() {
        return userDetailsRepository.findAll();
    }

    public Optional<UserDetails> getUserDetailsById(Integer id) {
        return userDetailsRepository.findById(id);
    }

    @Transactional
    public UserDetails createUserDetails(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @Transactional
    public void deleteUserDetails(Integer id) {
        userDetailsRepository.deleteById(id);
    }
}
