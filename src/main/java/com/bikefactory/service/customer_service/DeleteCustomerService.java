package com.bikefactory.service.customer_service;

public interface DeleteCustomerService {

    void removeCustomerById(Integer customerId);

    void removeCustomerByAccount(String customerAccount);
}
