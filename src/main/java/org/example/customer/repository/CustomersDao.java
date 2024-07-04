package org.example.customer.repository;

import org.example.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersDao {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerUsingId(Integer id);
    void insertCustomerToDB(Customer customer);
    boolean existCustomerWithEmail(String email);
    boolean existCustomerWithId(Integer id);
    void deleteCustomerFromDB(Customer customer);
    void updateCustomerDetails(Customer customer);
}
