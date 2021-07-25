package com.bikefactory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveOrUpdateSalesOrderDetailDto {

    private String carrierTrackingNumber;
    private Integer orderQty;
    private Integer productId;
    private Integer specialOfferId;
    private Double unitprice;
    private Double unitPriceDiscount;
    private String lineTotal;
}
