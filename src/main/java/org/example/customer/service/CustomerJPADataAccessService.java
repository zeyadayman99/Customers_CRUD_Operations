package org.example.customer.service;

import org.example.customer.model.Customer;
import org.example.customer.repository.CustomerRepository;
import org.example.customer.repository.CustomersDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class CustomerJPADataAccessService implements CustomersDao {
    private CustomerRepository customerRepository;

    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerUsingId(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void insertCustomerToDB(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean existCustomerWithEmail(String email) {
        return customerRepository.existsCustomerByEmail(email);
    }

    @Override
    public boolean existCustomerWithId(Integer id) {
        return customerRepository.existsCustomerById(id);
    }

    @Override
    public void deleteCustomerFromDB(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void updateCustomerDetails(Customer customer) {
        customerRepository.save(customer);
    }
}
