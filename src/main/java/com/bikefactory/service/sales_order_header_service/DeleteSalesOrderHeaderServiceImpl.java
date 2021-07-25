package com.bikefactory.service.sales_order_header_service;

import com.bikefactory.exception.SalesOrderHeaderNotFoundException;
import com.bikefactory.repository.SalesOrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteSalesOrderHeaderServiceImpl implements DeleteSalesOrderHeaderService {

    @Autowired
    private SalesOrderHeaderRepository salesOrderHeaderRepository;

    @Override
    public void deleteById(Integer id) {
        salesOrderHeaderRepository.delete(salesOrderHeaderRepository.findById(id)
                .orElseThrow(SalesOrderHeaderNotFoundException::new));
    }

    @Override
    public void deleteBySalesOrderNumber(String salesOrderNumber) {
        salesOrderHeaderRepository.delete(salesOrderHeaderRepository.findBySalesOrderNumber(salesOrderNumber)
                .orElseThrow(SalesOrderHeaderNotFoundException::new));
    }

    @Override
    public void deleteByRowGuide(String rowGuide) {
        salesOrderHeaderRepository.delete(salesOrderHeaderRepository.findFirstByOrderBySalesOrderIdDesc()
                .orElseThrow(SalesOrderHeaderNotFoundException::new));
    }
}
