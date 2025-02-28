package com.lhind.resource;

public record UserResource<Int>(
            Int id,
        String username,
        String role,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
}

