package com.bikefactory.service.sales_order_header_service;

import com.bikefactory.model.SalesOrderHeader;

public interface FetchSalesOrderHeaderService {

    SalesOrderHeader findByOrderId(Integer id);

    SalesOrderHeader findBySalesNumber(String salesNumber);

    SalesOrderHeader findByRow (String rowGuide);
}
