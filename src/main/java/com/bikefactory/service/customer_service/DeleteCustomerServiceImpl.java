package com.bikefactory.service.customer_service;

import com.bikefactory.exception.CustomerNotFoundException;
import com.bikefactory.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerServiceImpl implements DeleteCustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void removeCustomerById(Integer customerId) {
        customerRepository.delete(customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new));
    }

    @Override
    public void removeCustomerByAccount(String customerAccount) {
        customerRepository.delete(customerRepository.findByAccountNumber(customerAccount).orElseThrow(CustomerNotFoundException::new));
    }
}
