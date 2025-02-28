package com.lhind.controller;

import com.lhind.model.entity.UserDetails;
import com.lhind.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userdetails")
public class UserDetailsController {
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public List<UserDetails> getAllUserDetails() {
        return userDetailsService.getAllUserDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> getUserDetailsById(@PathVariable Integer id) {
        Optional<UserDetails> userDetails = userDetailsService.getUserDetailsById(id);
        return userDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserDetails createUserDetails(@RequestBody UserDetails userDetails) {
        return userDetailsService.createUserDetails(userDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDetails(@PathVariable Integer id) {
        userDetailsService.deleteUserDetails(id);
        return ResponseEntity.ok().build();
    }
}

