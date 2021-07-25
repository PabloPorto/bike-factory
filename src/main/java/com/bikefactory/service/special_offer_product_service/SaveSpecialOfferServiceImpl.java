package com.bikefactory.service.special_offer_product_service;

import com.bikefactory.dto.SaveOrUpdateSpecialOfferDto;
import com.bikefactory.exception.SpecialOfferNotFoundException;
import com.bikefactory.model.SpecialOfferProduct;
import com.bikefactory.repository.SpecialOfferProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;

@Service
public class SaveSpecialOfferServiceImpl implements SaveSpecialOfferService{

    @Autowired
    private SpecialOfferProductRepository specialOfferProductRepository;

    @Override
    public void saveSpecialOffer(SaveOrUpdateSpecialOfferDto saveOrUpdateSpecialOfferDto) {
        SpecialOfferProduct lastInserted = specialOfferProductRepository.findFirstByOrderByRowGuideDesc(saveOrUpdateSpecialOfferDto.getRowGuide())
                .orElseThrow(SpecialOfferNotFoundException::new);
        SpecialOfferProduct specialOfferProduct = new SpecialOfferProduct();

        specialOfferProduct.setSpecialOfferId(lastInserted.getSpecialOfferId()+1);
        specialOfferProduct.setProductId(lastInserted.getProductId()+1);
        specialOfferProduct.setRowGuide(saveOrUpdateSpecialOfferDto.getRowGuide());
        specialOfferProduct.setModifiedDate(Date.from(Instant.now()));

        specialOfferProductRepository.save(specialOfferProduct);

    }
}
