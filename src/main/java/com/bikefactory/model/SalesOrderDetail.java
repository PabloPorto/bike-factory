package com.bikefactory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "salesorderdetail")
public class SalesOrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salesorderid")
    private Integer salesOrderId;

    @Column(name = "salesorderdetailid")
    private Integer salesOrderDetailId;

    @Column(name="carriertrackingnumber")
    private String carrierTrackingNumber;

    @Column(name = "orderqty")
    private Integer orderQty;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "specialofferid")
    private Integer specialOfferId;

    @Column(name = "unitprice")
    private Double unitprice;

    @Column(name = "unitpricediscount")
    private Double unitPriceDiscount;

    @Column(name = "linetotal")
    private String lineTotal;

    @Column(name = "rowguide")
    private String rowGuide;

    @Column(name = "modifieddate")
    private Date modifiedDate;

}
