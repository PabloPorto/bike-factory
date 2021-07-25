package com.bikefactory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveOrUpdateSalesOrderHeaderDto {

    private Integer revisionNumber;
    private String orderDate;
    private String dueDate;
    private String shipDate;
    private String status;
    private Integer onlineOrderFlag;
    private String salesOrderNumber;
    private String purchaseOrderNumber;
    private String accountNumber;
    private Integer customerId;
    private Integer salesPersonId;
    private Integer territoryId;
    private Integer billToAddressId;
    private Integer shipMethodId;
    private Integer creditCardId;
    private String creditCardApprovalCode;
    private Integer currencyRateId;
    private Double subTotal;
    private Double taxAmt;
    private Double freight;
    private Double totaldue;
    private String textComment;
}
