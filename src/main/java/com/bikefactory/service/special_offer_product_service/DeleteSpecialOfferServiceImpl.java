package com.bikefactory.service.special_offer_product_service;

import com.bikefactory.exception.SpecialOfferNotFoundException;
import com.bikefactory.repository.SpecialOfferProductRepository;
import com.bikefactory.util.SpecialOfferProductRelationshipId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteSpecialOfferServiceImpl implements DeleteSpecialOfferService{

    @Autowired
    private SpecialOfferProductRepository specialOfferProductRepository;

    @Override
    public void deleteById(Integer specialOfferId, Integer productId) {
        SpecialOfferProductRelationshipId id = new SpecialOfferProductRelationshipId(specialOfferId, productId);
        specialOfferProductRepository.delete(specialOfferProductRepository.findById(id)
                .orElseThrow(SpecialOfferNotFoundException::new));
    }

    @Override
    public void deleteByRowGuide(String rowGuide) {
        specialOfferProductRepository.delete(specialOfferProductRepository.findByRowGuide(rowGuide)
                .orElseThrow(SpecialOfferNotFoundException::new));
    }
}
