package com.bikefactory.model;

import com.bikefactory.util.SalesOrderDetailRelationshipId;
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
@IdClass(SalesOrderDetailRelationshipId.class)
public class SalesOrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salesorderid")
    private Integer salesOrderId;

    @Id
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

    @Column(name = "rowguide", unique = true)
    private String rowGuide;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    @ManyToOne
    private SpecialOfferProduct specialOfferProduct;

    @ManyToOne
    private Product product;

    @ManyToOne
    private SalesOrderHeader salesOrderHeader;
}
