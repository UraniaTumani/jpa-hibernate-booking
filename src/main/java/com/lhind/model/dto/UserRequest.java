package com.lhind.model.dto;

import com.lhind.model.entity.User;
import com.lhind.model.entity.UserDetails;

public class UserRequest {
    private User user;
    private UserDetails userDetails;

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
