package com.bikefactory.controller;

import com.bikefactory.model.Customer;
import com.bikefactory.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> findCustomer(@PathVariable("id") Integer id){
        Customer customer = customerService.getCustomer(id);
        return ResponseEntity.ok().headers(new HttpHeaders()).body(customer);
    }
}
