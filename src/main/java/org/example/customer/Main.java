package org.example.customer;

import org.example.customer.model.Customer;
import org.example.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Main.class, args);
//        these are all the beans that's been managed for us by spring
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String bean : beanDefinitionNames)
//            System.out.println(bean);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            Customer ahmed =
                    new Customer("ahmed", 24, "ahmed@gmail.com");
            Customer jamila =
                    new Customer("jamila", 21, "jamila@gmail.com");
            List<Customer> customers = List.of(ahmed, jamila);
            customerRepository.saveAll(customers);
        };
    }
}

