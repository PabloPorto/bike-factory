package com.bikefactory.service.special_offer_product_service;

import com.bikefactory.exception.SpecialOfferNotFoundException;
import com.bikefactory.model.SpecialOfferProduct;
import com.bikefactory.repository.SpecialOfferProductRepository;
import com.bikefactory.util.SpecialOfferProductRelationshipId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchSpecialOfferServiceImpl implements FetchSpecialOfferService{

    @Autowired
    private SpecialOfferProductRepository specialOfferProductRepository;

    @Override
    public SpecialOfferProduct findById(Integer specialOfferId, Integer productId) {
        SpecialOfferProductRelationshipId id = new SpecialOfferProductRelationshipId(specialOfferId, productId);
        return specialOfferProductRepository.findById(id)
                .orElseThrow(SpecialOfferNotFoundException::new);
    }

    @Override
    public SpecialOfferProduct findByRowGuide(String rowGuide) {
        return specialOfferProductRepository.findByRowGuide(rowGuide)
                .orElseThrow(SpecialOfferNotFoundException::new);
    }
}
