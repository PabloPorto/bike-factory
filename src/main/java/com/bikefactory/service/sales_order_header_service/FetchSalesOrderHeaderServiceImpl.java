package com.bikefactory.service.sales_order_header_service;

import com.bikefactory.exception.SalesOrderHeaderNotFoundException;
import com.bikefactory.model.SalesOrderHeader;
import com.bikefactory.repository.SalesOrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchSalesOrderHeaderServiceImpl implements FetchSalesOrderHeaderService{

    @Autowired
    private SalesOrderHeaderRepository salesOrderHeaderRepository;

    @Override
    public SalesOrderHeader findByOrderId(Integer id) {
        return salesOrderHeaderRepository.findById(id)
                .orElseThrow(SalesOrderHeaderNotFoundException::new);
    }

    @Override
    public SalesOrderHeader findBySalesNumber(String salesNumber) {
        return salesOrderHeaderRepository.findBySalesOrderNumber(salesNumber)
                .orElseThrow(SalesOrderHeaderNotFoundException::new);
    }

    @Override
    public SalesOrderHeader findByRow(String rowGuide) {
        return salesOrderHeaderRepository.findByRowGuide(rowGuide)
                .orElseThrow(SalesOrderHeaderNotFoundException::new);
    }
}
