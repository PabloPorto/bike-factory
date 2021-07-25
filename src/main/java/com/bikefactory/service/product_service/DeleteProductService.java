package com.bikefactory.service.product_service;

public interface DeleteProductService  {

    void deleteByProductId(Integer id);

    void deleteByProductName(String name);

    void deleteByProductNumber (String productNumber);

    void deleteByRowGuide (String rowGuide);
}
