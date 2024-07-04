package org.example.customer.dto;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age
) {

}
