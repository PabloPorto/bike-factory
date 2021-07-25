package com.bikefactory.controller;

import com.bikefactory.dto.SaveOrUpdateSpecialOfferDto;
import com.bikefactory.model.SpecialOfferProduct;
import com.bikefactory.service.special_offer_product_service.DeleteSpecialOfferService;
import com.bikefactory.service.special_offer_product_service.FetchSpecialOfferService;
import com.bikefactory.service.special_offer_product_service.SaveSpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/special-offer")
public class SpecialOfferProductController {

    @Autowired
    private DeleteSpecialOfferService deleteSpecialOfferService;

    @Autowired
    private FetchSpecialOfferService fetchSpecialOfferService;

    @Autowired
    private SaveSpecialOfferService saveSpecialOfferService;

    @GetMapping(value="/fetch-by-id")
    public ResponseEntity<Object> findById(@RequestParam("specialOfferId") Integer specialOfferId,
                                           @RequestParam("productId") Integer productId){
        SpecialOfferProduct specialOfferProduct = fetchSpecialOfferService.findById(specialOfferId,productId);
        return ResponseEntity.status(HttpStatus.OK).body(specialOfferProduct);
    }

    @GetMapping(value="/fetch-by-rowguide/{rowGuide}")
    public ResponseEntity<Object> findByRowGuide(@PathVariable("rowGuide") String rowGuide){
        SpecialOfferProduct specialOfferProduct = fetchSpecialOfferService.findByRowGuide(rowGuide);
        return ResponseEntity.status(HttpStatus.OK).body(specialOfferProduct);
    }

    @DeleteMapping(value = "/delete-by-id")
    public ResponseEntity<Object> deleteById(@RequestParam("specialOfferId") Integer specialOfferId,
                                             @RequestParam("productId") Integer productId){
        deleteSpecialOfferService.deleteById(specialOfferId,productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/delete-by-rowguide/{rowGuide}")
    public ResponseEntity<Object> deleteByRowGuide(@PathVariable("rowGuide") String rowGuide){
        deleteSpecialOfferService.deleteByRowGuide(rowGuide);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveOrderDetail(@RequestBody SaveOrUpdateSpecialOfferDto saveOrUpdateSalesOrderDetailDto){
        saveSpecialOfferService.saveSpecialOffer(saveOrUpdateSalesOrderDetailDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
