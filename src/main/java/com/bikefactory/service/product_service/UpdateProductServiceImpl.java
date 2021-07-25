package com.bikefactory.service.product_service;

import com.bikefactory.dto.SaveOrUpdateProductDto;
import com.bikefactory.exception.ProductNotFoundException;
import com.bikefactory.model.Product;
import com.bikefactory.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

@Service
public class UpdateProductServiceImpl implements UpdateProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public void updateProduct(SaveOrUpdateProductDto productDto, Integer productId) throws ParseException {
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        String datePatter = "yyyy/MM/dd";

        product.setSellStartDate(new SimpleDateFormat(datePatter).parse(productDto.getSellStartDate()));
        product.setSellEndDate(new SimpleDateFormat(datePatter).parse(productDto.getSellEndDate()));
        product.setDiscontinuedDate(new SimpleDateFormat(datePatter).parse(productDto.getDiscontinuedDate()));
        product.setModifiedDate(Date.from(Instant.now()));

        modelMapper.map(productDto,product);
        productRepository.save(product);
    }
}
