package com.bikefactory.service.sales_order_detail_service;

import com.bikefactory.exception.SalesOrderDetailNotFoundException;
import com.bikefactory.repository.SalesOrderDetailRepository;
import com.bikefactory.util.SalesOrderDetailRelationshipId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteSalesOrderDetailImpl implements DeleteOrderDetailService{

    @Autowired
    private SalesOrderDetailRepository salesOrderDetailRepository;

    @Override
    public void deleteById(Integer salesOrderId, Integer salesOrderDetailId) {
        SalesOrderDetailRelationshipId id = new SalesOrderDetailRelationshipId(salesOrderId,salesOrderDetailId);
        salesOrderDetailRepository.deleteById(id);
    }

    @Override
    public void deleteByRowGuide(String rowGuide) {
        salesOrderDetailRepository.delete(salesOrderDetailRepository.findByRowGuide(rowGuide).orElseThrow(SalesOrderDetailNotFoundException::new));
    }
}
