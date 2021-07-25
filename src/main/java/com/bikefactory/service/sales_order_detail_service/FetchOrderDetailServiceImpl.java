package com.bikefactory.service.sales_order_detail_service;

import com.bikefactory.exception.SalesOrderDetailNotFoundException;
import com.bikefactory.model.SalesOrderDetail;
import com.bikefactory.repository.SalesOrderDetailRepository;
import com.bikefactory.util.SalesOrderDetailRelationshipId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchOrderDetailServiceImpl implements FetchOrderDetailService{

    @Autowired
    private SalesOrderDetailRepository salesOrderDetailRepository;

    @Override
    public SalesOrderDetail findById(Integer salesOrderId, Integer salesOrderDetailId) {
        SalesOrderDetailRelationshipId id = new SalesOrderDetailRelationshipId(salesOrderId,salesOrderDetailId);
        return salesOrderDetailRepository.findById(id).orElseThrow(SalesOrderDetailNotFoundException::new);
    }

    @Override
    public SalesOrderDetail findByRowGuide(String rowGuide) {
        return salesOrderDetailRepository.findByRowGuide(rowGuide).orElseThrow(SalesOrderDetailNotFoundException::new);
    }
}
