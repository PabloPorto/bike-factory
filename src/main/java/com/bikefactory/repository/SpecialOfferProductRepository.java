package com.bikefactory.repository;

import com.bikefactory.model.SpecialOfferProduct;
import com.bikefactory.util.SpecialOfferProductRelationshipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialOfferProductRepository extends JpaRepository<SpecialOfferProduct, SpecialOfferProductRelationshipId> {

    Optional<SpecialOfferProduct> findByRowGuide (String rowGuide);

    Optional<SpecialOfferProduct> findFirstByOrderByRowGuideDesc(String rowGuide);
}
