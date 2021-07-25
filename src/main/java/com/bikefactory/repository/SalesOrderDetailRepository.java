package com.bikefactory.repository;

import com.bikefactory.model.SalesOrderDetail;
import com.bikefactory.util.SalesOrderDetailRelationshipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesOrderDetailRepository extends JpaRepository<SalesOrderDetail, SalesOrderDetailRelationshipId> {

    Optional<SalesOrderDetail> findFirstByOrderByRowGuideDesc();

    Optional<SalesOrderDetail> findByRowGuide(String rowGuide);
}
