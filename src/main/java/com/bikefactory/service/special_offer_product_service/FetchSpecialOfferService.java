package com.bikefactory.service.special_offer_product_service;

import com.bikefactory.model.SpecialOfferProduct;

public interface FetchSpecialOfferService {

    SpecialOfferProduct findById(Integer specialOfferId, Integer productId);

    SpecialOfferProduct findByRowGuide(String rowGuide);
}
