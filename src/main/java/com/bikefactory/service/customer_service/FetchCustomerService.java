package com.bikefactory.service.customer_service;

import com.bikefactory.model.Customer;

public interface FetchCustomerService {

    Customer findCustomerById(Integer customerId);

    Customer findCustomerByAccount(String customerAccount);

    Customer findCustomerByRowGuide(String rowGuide);
}
