package com.bikefactory.service.sales_order_header_service;

import com.bikefactory.dto.SaveOrUpdateSalesOrderHeaderDto;

import java.text.ParseException;

@FunctionalInterface
public interface UpdateSalesOrderHeaderService {

    void update (SaveOrUpdateSalesOrderHeaderDto saveOrUpdateSalesOrderHeaderDto, Integer orderId) throws ParseException;
}
