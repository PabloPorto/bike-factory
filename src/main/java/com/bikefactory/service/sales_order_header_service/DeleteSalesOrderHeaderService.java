package com.bikefactory.service.sales_order_header_service;

public interface DeleteSalesOrderHeaderService {

    void deleteById (Integer id);

    void deleteBySalesOrderNumber(String salesOrderNumber);

    void deleteByRowGuide (String rowGuide);
}
