package com.bikefactory.service.sales_order_detail_service;

public interface DeleteOrderDetailService {

    void deleteById (Integer salesOrderId, Integer salesOrderDetailId);

    void deleteByRowGuide (String rowGuide);

}
