package com.bikefactory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveOrUpdateCustomerRequestDto {
    private Integer personId;
    private Integer storeId;
    private Integer territoryId;
    private String accountNumber;
}
