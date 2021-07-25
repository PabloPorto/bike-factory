package com.bikefactory.service.sales_order_detail_service;

import com.bikefactory.dto.SaveOrUpdateSalesOrderDetailDto;

@FunctionalInterface
public interface SaveOrderDetailService {

    void save(SaveOrUpdateSalesOrderDetailDto saveOrUpdateSalesOrderDetailDto);
}
