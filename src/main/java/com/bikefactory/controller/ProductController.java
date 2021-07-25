package com.bikefactory.controller;

import com.bikefactory.dto.SaveOrUpdateProductDto;
import com.bikefactory.exception.ValidationException;
import com.bikefactory.model.Product;
import com.bikefactory.service.product_service.DeleteProductService;
import com.bikefactory.service.product_service.FetchProductService;
import com.bikefactory.service.product_service.SaveProductService;
import com.bikefactory.service.product_service.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private SaveProductService saveProductService;

    @Autowired
    private FetchProductService fetchProductService;

    @Autowired
    private UpdateProductService updateProductService;

    @Autowired
    private DeleteProductService deleteProductService;

    @GetMapping(value="/fetch-by-id/{productId}")
    public ResponseEntity<Object> findProdById(@PathVariable("productId") Integer productId){
        Product product = fetchProductService.findProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping(value="/fetch-by-rowguide/{rowGuide}")
    public ResponseEntity<Object> findProdByRowGuide(@PathVariable("rowGuide") String rowGuide){
        Product product = fetchProductService.findProductByRowGuide(rowGuide);
        return ResponseEntity.status(HttpStatus.OK).body(product);

    }

    @GetMapping(value="/fetch-by-name/{name}")
    public ResponseEntity<Object> findProdByName(@PathVariable("name") String name){
        Product product = fetchProductService.findProductByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(product);

    }

    @GetMapping(value="/fetch-by-product-number/{productNumber}")
    public ResponseEntity<Object> findByProdNumber(@PathVariable("productNumber") String productNumber){
        Product product = fetchProductService.findProductByProductNumber(productNumber);
        return ResponseEntity.status(HttpStatus.OK).body(product);

    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@Valid @RequestBody SaveOrUpdateProductDto productDto,
                                              Errors errors) throws ParseException {
        if (errors.hasErrors()) {
            return validationErrorResponse(errors);
        }
        saveProductService.insertNewProduct(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{productId}")
    public ResponseEntity<Object> updateProduct(@PathVariable("productId") Integer productId,
                                                @Valid @RequestBody SaveOrUpdateProductDto productDto,
                                                Errors errors) throws ParseException {
        if (errors.hasErrors()) {
            return validationErrorResponse(errors);
        }
        updateProductService.updateProduct(productDto,productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id/{productId}")
    public ResponseEntity<Object> deleteById(@PathVariable ("productId") Integer productId){
        deleteProductService.deleteByProductId(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-name/{productName}")
    public ResponseEntity<Object> deleteByName(@PathVariable ("productName") String productName){
        deleteProductService.deleteByProductName(productName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-number/{productNumber}")
    public ResponseEntity<Object> deleteByNumber(@PathVariable ("productNumber") String productNumber){
        deleteProductService.deleteByProductNumber(productNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-rowguide/{rowGuide}")
    public ResponseEntity<Object> deleteByRowGuide(@PathVariable ("rowGuide") String rowGuide){
        deleteProductService.deleteByRowGuide(rowGuide);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "OPTIONS, HEAD, GET, POST, PUT, PATCH");
        headers.add("Access-Control-Allow-Headers", "Content-Type");
        return headers;
    }

    private ResponseEntity<Object> validationErrorResponse(Errors errors) {
        return new ResponseEntity<>(
                new ValidationException(errors.getAllErrors().stream()
                        .map(ObjectError::getDefaultMessage).collect(Collectors.toList())).getStandardError(),
                getHttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
