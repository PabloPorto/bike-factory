package com.bikefactory.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesOrderDetailRelationshipId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer salesOrderId;
    private Integer salesOrderDetailId;

}
