package org.example.customer.service;

import org.example.customer.model.Customer;
import org.example.customer.repository.CustomersDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("List")
public class CustomerListDataAccessService implements CustomersDao {
    private static List<Customer> customers;
    static {
        customers = new ArrayList<>();
        Customer ahmed = new Customer(1, "ahmed", 24, "ahmed@gmail.com");
        customers.add(ahmed);
        Customer jamila = new Customer(2, "jamila", 21, "jamila@gmail.com");
        customers.add(jamila);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    //which is designed to address issues related to null
    //references and improve code readability and safety.
    @Override
    public Optional<Customer> getCustomerUsingId(Integer id) {
        Optional<Customer> c = customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
        return c;
    }

    @Override
    public void insertCustomerToDB(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existCustomerWithEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public boolean existCustomerWithId(Integer id) {
        return customers.stream()
                .allMatch(c -> c.getId().equals(id));
    }

    @Override
    public void deleteCustomerFromDB(Customer customer) {
        customers.stream()
                .filter(c -> c.getId().equals(customer.getId()))
                .findFirst()
                .ifPresent(c -> customers.remove(c));
    }

    @Override
    public void updateCustomerDetails(Customer customer) {
        customers.add(customer);
    }

}
