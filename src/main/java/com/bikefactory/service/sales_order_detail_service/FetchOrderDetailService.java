package com.bikefactory.service.sales_order_detail_service;

import com.bikefactory.model.SalesOrderDetail;

public interface FetchOrderDetailService {

    SalesOrderDetail findById(Integer salesOrderId, Integer salesOrderDetailId);

    SalesOrderDetail findByRowGuide (String rowGuide);
}
