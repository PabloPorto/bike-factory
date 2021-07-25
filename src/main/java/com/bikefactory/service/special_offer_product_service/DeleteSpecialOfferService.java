package com.bikefactory.service.special_offer_product_service;

public interface DeleteSpecialOfferService {

    void deleteById(Integer specialOfferId, Integer productId);

    void deleteByRowGuide(String rowGuide);
}
