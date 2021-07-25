package com.bikefactory.service.product_service;

import com.bikefactory.exception.ProductNotFoundException;
import com.bikefactory.model.Product;
import com.bikefactory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchProductServiceImpl implements FetchProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findByName(name).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product findProductByProductNumber(String productNumber) {
        return productRepository.findByProductNumber(productNumber).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product findProductByRowGuide(String rowGuide) {
        return productRepository.findByRowGuide(rowGuide).orElseThrow(ProductNotFoundException::new);
    }
}
