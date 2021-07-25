package com.bikefactory.repository;

import com.bikefactory.model.SalesOrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesOrderHeaderRepository extends JpaRepository<SalesOrderHeader,Integer> {

    Optional<SalesOrderHeader> findFirstByOrderBySalesOrderIdDesc();

    Optional<SalesOrderHeader> findBySalesOrderNumber(String salesOrderNumber);

    Optional<SalesOrderHeader> findByRowGuide(String id);
}
