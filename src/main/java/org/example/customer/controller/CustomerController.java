package org.example.customer.controller;

import org.example.customer.dto.CustomerRegistrationRequest;
import org.example.customer.dto.CustomerUpdateRequest;
import org.example.customer.model.Customer;
import org.example.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //1st endpoint
    @RequestMapping(
            method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    //2nd endpoint
    @GetMapping("{customerId}")
    public Customer getCustomerUsingId(
            @PathVariable("customerId") Integer customerId){
        return customerService.getCustomerUsingId(customerId);
    }

    //3rd endpoint
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request) {
        customerService.insertCustomerToDB(request);
    }

    //4th endpoint
    @DeleteMapping("{customerId}")
    public void deleteCustomerFromDB(@PathVariable("customerId") Integer id) {
        customerService.deleterCustomerFromDB(id);
    }

    //5th endpoint
    @PutMapping("{customerId}")
    public void updateCustomerDetails(@PathVariable Integer customerId,
                                      @RequestBody CustomerUpdateRequest request) {
        customerService.updateCustomerDetails(customerId, request);
    }
}
