package com.bikefactory.service.customer_service;

import com.bikefactory.dto.SaveOrUpdateCustomerRequestDto;

@FunctionalInterface
public interface UpdateCustomerService {

    void updateCustomer(SaveOrUpdateCustomerRequestDto updateCustomerDto, Integer customerId);

}
