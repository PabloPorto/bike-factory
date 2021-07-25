package com.bikefactory.service.customer_service;

import com.bikefactory.dto.SaveOrUpdateCustomerRequestDto;
import com.bikefactory.exception.CustomerNotFoundException;
import com.bikefactory.model.Customer;
import com.bikefactory.repository.CustomerRepository;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.time.Instant;

@Service
public class UpdateCustomerServiceImpl implements UpdateCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void updateCustomer(SaveOrUpdateCustomerRequestDto saveOrUpdateCustomerRequestDto, Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
        customer.setModifiedDate(Date.from(Instant.now()));

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(saveOrUpdateCustomerRequestDto, customer);

        customerRepository.save(customer);

    }
}
