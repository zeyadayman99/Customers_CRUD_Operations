package org.example.customer.repository;

import org.example.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {

    //this is the way by which JPA will construct the query for us based on this method
    @Query
    boolean existsCustomerByEmail(String email);
    @Query
    boolean existsCustomerById(Integer id);
}
