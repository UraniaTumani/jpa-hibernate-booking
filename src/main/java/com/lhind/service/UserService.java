package com.lhind.service;


import com.lhind.model.entity.User;
import com.lhind.model.entity.UserDetails;
import com.lhind.repository.UserDetailsRepository;
import com.lhind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User createUserWithDetails(User user, UserDetails userDetails) {
        user.setUserDetails(userDetails);
        userDetails.setUser(user);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userDetailsRepository.deleteById(Math.toIntExact(id));
            userRepository.deleteById(id);
        }
    }
}
