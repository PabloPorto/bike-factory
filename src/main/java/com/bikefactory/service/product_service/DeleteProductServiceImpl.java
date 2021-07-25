package com.bikefactory.service.product_service;

import com.bikefactory.exception.ProductNotFoundException;
import com.bikefactory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductServiceImpl implements DeleteProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void deleteByProductId(Integer id) {
        productRepository.delete(productRepository.findById(id).orElseThrow(ProductNotFoundException::new));
    }

    @Override
    public void deleteByProductName(String name) {
        productRepository.delete(productRepository.findByName(name).orElseThrow(ProductNotFoundException::new));
    }

    @Override
    public void deleteByProductNumber(String productNumber) {
        productRepository.delete(productRepository.findByProductNumber(productNumber).orElseThrow(ProductNotFoundException::new));
    }

    @Override
    public void deleteByRowGuide(String rowGuide) {
        productRepository.delete(productRepository.findByRowGuide(rowGuide).orElseThrow(ProductNotFoundException::new));
    }
}
