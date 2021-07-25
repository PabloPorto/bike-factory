package com.bikefactory.repository;

import com.bikefactory.model.SpecialOfferProduct;
import com.bikefactory.util.SpecialOfferProductRelationshipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialOfferProductRepository extends JpaRepository<SpecialOfferProduct, SpecialOfferProductRelationshipId> {
}
