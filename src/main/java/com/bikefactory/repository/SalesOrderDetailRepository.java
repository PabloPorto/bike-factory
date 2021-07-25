package com.bikefactory.repository;

import com.bikefactory.model.SalesOrderDetail;
import com.bikefactory.util.SalesOrderDetailRelationshipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderDetailRepository extends JpaRepository<SalesOrderDetail, SalesOrderDetailRelationshipId> {
}
