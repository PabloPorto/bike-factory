package com.bikefactory.service.sales_order_detail_service;

import com.bikefactory.dto.SaveOrUpdateSalesOrderDetailDto;

@FunctionalInterface
public interface UpdateOrderDetailService {

    void updateOrderDetail(SaveOrUpdateSalesOrderDetailDto saveOrUpdateSalesOrderDetailDto,
                           Integer orderId, Integer orderDetailId);
}
