package com.bikefactory.service.product_service;

import com.bikefactory.model.Product;

public interface FetchProductService {

    Product findProductById (Integer id);

    Product findProductByName (String name);

    Product findProductByProductNumber (String productNumber);

    Product findProductByRowGuide (String rowGuide);
}
