package com.bikefactory.controller;

import com.bikefactory.dto.SaveOrUpdateSalesOrderDetailDto;
import com.bikefactory.model.SalesOrderDetail;
import com.bikefactory.service.sales_order_detail_service.DeleteOrderDetailService;
import com.bikefactory.service.sales_order_detail_service.FetchOrderDetailService;
import com.bikefactory.service.sales_order_detail_service.SaveOrderDetailService;
import com.bikefactory.service.sales_order_detail_service.UpdateOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/order-detail")
public class OrderDetailController {

    @Autowired
    private DeleteOrderDetailService deleteOrderDetailService;

    @Autowired
    private FetchOrderDetailService fetchOrderDetailService;

    @Autowired
    private SaveOrderDetailService saveOrderDetailService;

    @Autowired
    private UpdateOrderDetailService updateOrderDetailService;

    @GetMapping(value="/fetch-by-id")
    public ResponseEntity<Object> findOrderDetailById(@RequestParam("salesOrderId") Integer salesOrderId,
                                                      @RequestParam("salesOrderDetailId") Integer salesOrderDetailId){
        SalesOrderDetail salesOrderDetail = fetchOrderDetailService.findById(salesOrderId,salesOrderDetailId);
        return ResponseEntity.ok().headers(new HttpHeaders()).body(salesOrderDetail);
    }

    @GetMapping(value="/fetch-by-rowguide/{rowGuide}")
    public ResponseEntity<Object> findByRowGuide(@PathVariable("rowGuide") String rowGuide){
        SalesOrderDetail salesOrderDetail = fetchOrderDetailService.findByRowGuide(rowGuide);
        return ResponseEntity.ok().headers(new HttpHeaders()).body(salesOrderDetail);
    }

    @DeleteMapping(value = "/delete-by-id")
    public ResponseEntity<Object> deleteById(@RequestParam("salesOrderId") Integer salesOrderId,
                                             @RequestParam("salesOrderDetailId") Integer salesOrderDetailId){
        deleteOrderDetailService.deleteById(salesOrderId,salesOrderDetailId);
        return new ResponseEntity<>(new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(value="/delete-by-rowguide/{rowGuide}")
    public ResponseEntity<Object> deleteByRowGuide(@PathVariable("rowGuide") String rowGuide){
        deleteOrderDetailService.deleteByRowGuide(rowGuide);
        return new ResponseEntity<>(new HttpHeaders(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveOrderDetail(@RequestBody SaveOrUpdateSalesOrderDetailDto saveOrUpdateSalesOrderDetailDto){
        saveOrderDetailService.save(saveOrUpdateSalesOrderDetailDto);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateOrderDetail(@RequestBody SaveOrUpdateSalesOrderDetailDto saveOrUpdateSalesOrderDetailDto,
                                                    @RequestParam("salesOrderId") Integer salesOrderId,
                                                    @RequestParam("salesOrderDetailId") Integer salesOrderDetailId){
        updateOrderDetailService.updateOrderDetail(saveOrUpdateSalesOrderDetailDto,salesOrderId,salesOrderDetailId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
}
