package com.bikefactory.repository;

import com.bikefactory.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByAccountNumber(String accountNumber);

    Optional<Customer> findFirstByOrderByCustomerIdDesc();

    Optional<Customer> findCustomerByRowGuide(String rowGuide);
}
