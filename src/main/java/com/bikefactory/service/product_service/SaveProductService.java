package com.bikefactory.service.product_service;

import com.bikefactory.dto.SaveOrUpdateProductDto;

import java.text.ParseException;

public interface SaveProductService {

    void insertNewProduct(SaveOrUpdateProductDto productDto) throws ParseException;
}
