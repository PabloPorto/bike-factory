package com.bikefactory.controller;

import com.bikefactory.dto.SaveOrUpdateCustomerRequestDto;
import com.bikefactory.model.Customer;
import com.bikefactory.service.customer_service.DeleteCustomerService;
import com.bikefactory.service.customer_service.FetchCustomerService;
import com.bikefactory.service.customer_service.SaveCustomerService;
import com.bikefactory.service.customer_service.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    @Autowired
    private SaveCustomerService saveCustomerService;

    @Autowired
    private FetchCustomerService fetchCustomerService;

    @Autowired
    private UpdateCustomerService updateCustomerService;

    @Autowired
    private DeleteCustomerService deleteCustomerService;

    @GetMapping(value="/fetch-by-id/{id}")
    public ResponseEntity<Object> findCustomer(@PathVariable("id") Integer id){
        Customer customer = fetchCustomerService.findCustomerById(id);
        return ResponseEntity.ok().headers(new HttpHeaders()).body(customer);
    }

    @GetMapping(value="/fetch-by-account/{accountNumber}")
    public ResponseEntity<Object> findCustomerByAccountNumber(@PathVariable("accountNumber") String accountNumber){
        Customer customer = fetchCustomerService.findCustomerByAccount(accountNumber);
        return ResponseEntity.ok().headers(new HttpHeaders()).body(customer);
    }

    @GetMapping(value="/fetch-rowguide/{rowGuide}")
    public ResponseEntity<Object> findByRowGuide(@PathVariable("rowGuide") String rowGuide){
        Customer customer = fetchCustomerService.findCustomerByRowGuide(rowGuide);
        return ResponseEntity.ok().headers(new HttpHeaders()).body(customer);
    }

    @PostMapping
    public ResponseEntity<Object> saveNewCustomer(@RequestBody SaveOrUpdateCustomerRequestDto saveOrUpdateCustomerRequestDto){
        saveCustomerService.insertNewCustomer(saveOrUpdateCustomerRequestDto);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(value="/update/{customerId}")
    public ResponseEntity<Object> update(@PathVariable ("customerId") Integer customerId,
                                         @RequestBody SaveOrUpdateCustomerRequestDto saveOrUpdateCustomerRequestDto){
        updateCustomerService.updateCustomer(saveOrUpdateCustomerRequestDto,customerId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id/{customerId}")
    public ResponseEntity<Object> deleteById(@PathVariable ("customerId") Integer customerId){
        deleteCustomerService.removeCustomerById(customerId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-account/{account}")
    public ResponseEntity<Object> deleteById(@PathVariable ("account") String account){
        deleteCustomerService.removeCustomerByAccount(account);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

}
