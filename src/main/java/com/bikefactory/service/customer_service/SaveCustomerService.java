package com.bikefactory.service.customer_service;

import com.bikefactory.dto.SaveOrUpdateCustomerRequestDto;

@FunctionalInterface
public interface SaveCustomerService{

        void insertNewCustomer(SaveOrUpdateCustomerRequestDto saveOrUpdateCustomerRequestDto);
}
