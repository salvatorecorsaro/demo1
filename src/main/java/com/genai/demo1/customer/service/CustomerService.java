package com.genai.demo1.customer.service;

import com.genai.demo1.customer.aggregate.Customer;
import com.genai.demo1.customer.dto.CreateCustomerCommand;
import com.genai.demo1.customer.repository.CustomerRepository;
import com.genai.demo1.customer.valueobject.PersonalInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;


    public Customer registerCustomer(CreateCustomerCommand createCustomerCommand) {
        PersonalInformation personalInformation = createCustomerCommand.getPersonalInformation();
        Customer customer = new Customer(personalInformation);
        return customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerById(UUID id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
