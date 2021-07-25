package com.bikefactory.repository;

import com.bikefactory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Optional<Product> findByName(String name);

    Optional<Product> findByProductNumber (String productNumber);

    Optional<Product> findByRowGuide (String rowGuide);

    Optional<Product> findFirstByOrderByProductIdDesc();
}
