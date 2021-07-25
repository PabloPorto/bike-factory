package com.bikefactory.service.customer_service;

import com.bikefactory.dto.SaveOrUpdateCustomerRequestDto;
import com.bikefactory.exception.TableEmptyException;
import com.bikefactory.model.Customer;
import com.bikefactory.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

@Service
public class SaveCustomerServiceImpl implements SaveCustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void insertNewCustomer(SaveOrUpdateCustomerRequestDto saveOrUpdateCustomerRequestDto) {
        String rowGuide = UUID.randomUUID().toString();
        Customer lastInserted = customerRepository.findFirstByOrderByCustomerIdDesc().orElseThrow(TableEmptyException::new);

        Customer customer = new Customer(saveOrUpdateCustomerRequestDto.getPersonId(),
                saveOrUpdateCustomerRequestDto.getStoreId(),
                saveOrUpdateCustomerRequestDto.getTerritoryId(),
                saveOrUpdateCustomerRequestDto.getAccountNumber());
        customer.setRowGuide(rowGuide);
        customer.setModifiedDate(Date.from(Instant.now()));
        customer.setCustomerId(lastInserted.getCustomerId()+1);
        customerRepository.save(customer);
    }
}
