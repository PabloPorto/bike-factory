package com.bikefactory.service.product_service;

import com.bikefactory.dto.SaveOrUpdateProductDto;
import com.bikefactory.exception.ProductNotFoundException;
import com.bikefactory.exception.TableEmptyException;
import com.bikefactory.model.Product;
import com.bikefactory.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.UUID;

@Service
public class SaveProductServiceImpl implements SaveProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public void insertNewProduct(SaveOrUpdateProductDto productDto) throws ParseException {
        Product lastInserted = productRepository.findFirstByOrderByProductIdDesc().orElseThrow(TableEmptyException::new);
        String rowGuide = UUID.randomUUID().toString();
        String datePatter = "yyyy/MM/dd";
        Product product = new Product();

        product.setProductId(lastInserted.getProductId()+1);
        product.setSellStartDate(new SimpleDateFormat(datePatter).parse(productDto.getSellStartDate()));
        product.setSellEndDate(new SimpleDateFormat(datePatter).parse(productDto.getSellEndDate()));
        product.setDiscontinuedDate(new SimpleDateFormat(datePatter).parse(productDto.getDiscontinuedDate()));
        product.setModifiedDate(Date.from(Instant.now()));
        product.setRowGuide(rowGuide);

        modelMapper.map(productDto,product);
        productRepository.save(product);
    }
}