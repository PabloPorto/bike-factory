package com.bikefactory.controller;

import com.bikefactory.dto.SaveOrUpdateSalesOrderHeaderDto;
import com.bikefactory.model.SalesOrderHeader;
import com.bikefactory.service.sales_order_header_service.DeleteSalesOrderHeaderService;
import com.bikefactory.service.sales_order_header_service.FetchSalesOrderHeaderService;
import com.bikefactory.service.sales_order_header_service.SaveSalesOrderHeaderService;
import com.bikefactory.service.sales_order_header_service.UpdateSalesOrderHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/bike-factory/order-header")
public class SalesOrderHeaderController {

    @Autowired
    private DeleteSalesOrderHeaderService deleteSalesOrderHeaderService;

    @Autowired
    private FetchSalesOrderHeaderService fetchSalesOrderHeaderService;

    @Autowired
    private SaveSalesOrderHeaderService saveSalesOrderHeaderService;

    @Autowired
    private UpdateSalesOrderHeaderService updateSalesOrderHeaderService;

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Object> deleteById(@PathVariable("orderId") Integer orderId){
        deleteSalesOrderHeaderService.deleteById(orderId);
        return new ResponseEntity<>(new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/number/{orderNumber}")
    public ResponseEntity<Object> deleteByNumber(@PathVariable("orderNumber") String orderNumber){
        deleteSalesOrderHeaderService.deleteBySalesOrderNumber(orderNumber);
        return new ResponseEntity<>(new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/rowguide/{rowGuide}")
    public ResponseEntity<Object> deleteByRowGuide(@PathVariable("rowGuide") String rowGuide){
        deleteSalesOrderHeaderService.deleteByRowGuide(rowGuide);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<Object> findByid(@PathVariable("orderId") Integer orderId){
        SalesOrderHeader salesOrderHeader = fetchSalesOrderHeaderService.findByOrderId(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(salesOrderHeader);
    }

    @GetMapping(value = "/number/{salesNumber}")
    public ResponseEntity<Object> findBySalesNumber(@PathVariable("salesNumber") String salesNumber){
        SalesOrderHeader salesOrderHeader = fetchSalesOrderHeaderService.findBySalesNumber(salesNumber);
        return ResponseEntity.status(HttpStatus.OK).body(salesOrderHeader);
    }

    @GetMapping(value = "/rowguide/{rowGuide}")
    public ResponseEntity<Object> findByRowGuide(@PathVariable("rowGuide") String rowGuide){
        SalesOrderHeader salesOrderHeader = fetchSalesOrderHeaderService.findByRow(rowGuide);
        return ResponseEntity.status(HttpStatus.OK).body(salesOrderHeader);
    }

    @PostMapping
    public ResponseEntity<Object> saveSalesHeader(@RequestBody SaveOrUpdateSalesOrderHeaderDto saveOrUpdateSalesOrderHeaderDto) throws ParseException {
        saveSalesOrderHeaderService.insertNewSalesOrderHeader(saveOrUpdateSalesOrderHeaderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{orderId}")
    public ResponseEntity<Object> updateSalesHeader(@RequestBody SaveOrUpdateSalesOrderHeaderDto saveOrUpdateSalesOrderHeaderDto,
                                                    @PathVariable("orderId") Integer orderId) throws ParseException{
        updateSalesOrderHeaderService.update(saveOrUpdateSalesOrderHeaderDto, orderId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
