package com.bikefactory.service.product_service;

import com.bikefactory.dto.SaveOrUpdateProductDto;

import java.text.ParseException;

@FunctionalInterface
public interface UpdateProductService {

    void updateProduct(SaveOrUpdateProductDto productDto, Integer productId) throws ParseException;
}
