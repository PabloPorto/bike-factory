package com.bikefactory.service.customer_service;

import com.bikefactory.exception.CustomerNotFoundException;
import com.bikefactory.exception.RowGuidNotFoundException;
import com.bikefactory.model.Customer;
import com.bikefactory.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchCustomerServiceImpl implements FetchCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public Customer findCustomerByAccount(String customerAccount) {
        return customerRepository.findByAccountNumber(customerAccount).orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public Customer findCustomerByRowGuide(String rowGuide){
        return customerRepository.findCustomerByRowGuide(rowGuide).orElseThrow(RowGuidNotFoundException::new);
    }

}
