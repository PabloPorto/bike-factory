package com.bikefactory.service.special_offer_product_service;

import com.bikefactory.dto.SaveOrUpdateSpecialOfferDto;

@FunctionalInterface
public interface SaveSpecialOfferService {

    void saveSpecialOffer(SaveOrUpdateSpecialOfferDto saveOrUpdateSpecialOfferDto);
}
