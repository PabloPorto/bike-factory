package com.bikefactory.controller;

import com.bikefactory.dto.SaveOrUpdateSalesOrderDetailDto;
import com.bikefactory.model.SalesOrderDetail;
import com.bikefactory.service.sales_order_detail_service.DeleteOrderDetailService;
import com.bikefactory.service.sales_order_detail_service.FetchOrderDetailService;
import com.bikefactory.service.sales_order_detail_service.SaveOrderDetailService;
import com.bikefactory.service.sales_order_detail_service.UpdateOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bike-factory/order-detail")
public class OrderDetailController {

    @Autowired
    private DeleteOrderDetailService deleteOrderDetailService;

    @Autowired
    private FetchOrderDetailService fetchOrderDetailService;

    @Autowired
    private SaveOrderDetailService saveOrderDetailService;

    @Autowired
    private UpdateOrderDetailService updateOrderDetailService;

    @GetMapping(value="/orders")
    public ResponseEntity<Object> findOrderDetailById(@RequestParam("salesOrderId") Integer salesOrderId,
                                                      @RequestParam("salesOrderDetailId") Integer salesOrderDetailId){
        SalesOrderDetail salesOrderDetail = fetchOrderDetailService.findById(salesOrderId,salesOrderDetailId);
        return ResponseEntity.status(HttpStatus.OK).body(salesOrderDetail);
    }

    @GetMapping(value="/{rowGuide}")
    public ResponseEntity<Object> findByRowGuide(@PathVariable("rowGuide") String rowGuide){
        SalesOrderDetail salesOrderDetail = fetchOrderDetailService.findByRowGuide(rowGuide);
        return ResponseEntity.status(HttpStatus.OK).body(salesOrderDetail);
    }

    @DeleteMapping(value = "/{id}/orders")
    public ResponseEntity<Object> deleteById(@RequestParam("salesOrderId") Integer salesOrderId,
                                             @RequestParam("salesOrderDetailId") Integer salesOrderDetailId){
        deleteOrderDetailService.deleteById(salesOrderId,salesOrderDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/{rowGuide}")
    public ResponseEntity<Object> deleteByRowGuide(@PathVariable("rowGuide") String rowGuide){
        deleteOrderDetailService.deleteByRowGuide(rowGuide);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveOrderDetail(@RequestBody SaveOrUpdateSalesOrderDetailDto saveOrUpdateSalesOrderDetailDto){
        saveOrderDetailService.save(saveOrUpdateSalesOrderDetailDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/orders")
    public ResponseEntity<Object> updateOrderDetail(@RequestBody SaveOrUpdateSalesOrderDetailDto saveOrUpdateSalesOrderDetailDto,
                                                    @RequestParam("salesOrderId") Integer salesOrderId,
                                                    @RequestParam("salesOrderDetailId") Integer salesOrderDetailId){
        updateOrderDetailService.updateOrderDetail(saveOrUpdateSalesOrderDetailDto,salesOrderId,salesOrderDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
