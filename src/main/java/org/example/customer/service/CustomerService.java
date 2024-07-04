package org.example.customer.service;

import org.example.customer.dto.CustomerRegistrationRequest;
import org.example.customer.dto.CustomerUpdateRequest;
import org.example.customer.model.Customer;
import org.example.customer.repository.CustomersDao;
import org.example.customer.exceptions.DuplicateResourceException;
import org.example.customer.exceptions.RequestValidationException;
import org.example.customer.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomersDao customersDao;

    public CustomerService(@Qualifier("jpa") CustomersDao customersDao)
    {
        this.customersDao = customersDao;
    }

    public List<Customer> getCustomers() {
        return customersDao.getAllCustomers();
    }

    public Customer getCustomerUsingId(Integer id) {
        return customersDao.getCustomerUsingId(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                        "can't find any customer with id{" + id + "}".formatted(id)));
    }

    public void insertCustomerToDB
            (CustomerRegistrationRequest customerRegistrationRequest){
        //check if email exists
        String email = customerRegistrationRequest.email();
        if (customersDao.existCustomerWithEmail
                (customerRegistrationRequest.email())) {
            throw new DuplicateResourceException("customer with email [%s] already exists"
                    .formatted(email));
        }
        //if not, then we add it to DB
        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.age(),
                email
        );
        customersDao.insertCustomerToDB(customer);
    }
    public void deleterCustomerFromDB(Integer id) {
        if(!customersDao.existCustomerWithId(id)) {
            throw new DuplicateResourceException("customer with id [%s] doesn't exist"
                    .formatted(id));
        }
        Optional<Customer> customer = customersDao.getCustomerUsingId(id);
        customersDao.deleteCustomerFromDB(customer.orElse(null));
    }
    public void updateCustomerDetails(Integer customerId, CustomerUpdateRequest request) {
        Customer customer = getCustomerUsingId(customerId);
        boolean change = false;
        if(!customer.getName().equals(request.name()) && customer.getName() != null) {
            customer.setName(request.name());
            change = true;
        }
        if(!customer.getAge().equals(request.age()) && customer.getAge() != null) {
            customer.setAge(request.age());
            change = true;
        }
        if(!customer.getEmail().equals(request.email()) && customer.getEmail() != null) {
            if (customersDao.existCustomerWithEmail
                    (request.email())) {
                throw new DuplicateResourceException("customer with email [%s] already exists"
                        .formatted(request.email()));
            }
            customer.setEmail(request.email());
            change = true;
        }
        if(!change) {
            throw new RequestValidationException("no changes to update");
        }
            customersDao.updateCustomerDetails(customer);
    }
}
