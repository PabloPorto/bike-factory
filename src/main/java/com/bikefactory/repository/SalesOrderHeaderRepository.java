package com.bikefactory.repository;

import com.bikefactory.model.SalesOrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderHeaderRepository extends JpaRepository<SalesOrderHeader,Integer> {
}
