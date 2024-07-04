package org.example.customer.dto;

public record CustomerUpdateRequest(
        String name,
        Integer age,
        String email
) {
}
