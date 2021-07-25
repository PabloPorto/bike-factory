package com.bikefactory.service;

import com.bikefactory.exception.CustomerNotFoundException;
import com.bikefactory.model.Customer;
import com.bikefactory.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }
}
