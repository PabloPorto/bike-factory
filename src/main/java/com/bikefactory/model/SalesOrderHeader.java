package com.bikefactory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="salesorderheader")
public class SalesOrderHeader implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="salesorderid")
    private Integer salesOrderId;

    @Column(name = "revisionnumber")
    private Integer revisionNumber;

    @Column(name = "orderdate")
    private Date orderDate;

    @Column(name = "duedate")
    private Date dueDate;

    @Column(name = "shipdate")
    private Date shipDate;

    private String status;

    @Column(name = "onlineorderflag")
    private Integer onlineOrderFlag;

    @Column(name = "purchaseordernumber")
    private String purchaseOrderNumber;

    @Column(name = "acountnumber")
    private String accountNumber;

    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "salespersonid")
    private Integer salesPersonId;

    @Column(name = "territoryid")
    private Integer territoryId;

    @Column(name = "billtoadressid")
    private Integer billToAddressId;

    @Column(name = "shipmethodid")
    private Integer shipMethodId;

    @Column(name = "creditcardid")
    private Integer creditCardId;

    @Column(name = "creditcardapprovalcode")
    private String creditCardApprovalCode;

    @Column(name = "currancyrateid")
    private Integer currencyRateId;

    @Column(name = "subtotal")
    private Double subTotal;

    @Column(name = "taxamt")
    private Double taxAmt;

    private Double freight;

    @Column(name = "totaldue")
    private Double totaldue;

    @Column(name = "textcomment")
    private String textComment;

    @Column(name = "rowguide")
    private String rowGuide;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    @OneToMany(mappedBy = "salesOrderId")
    private List<SalesOrderDetail> salesOrderDetails = new ArrayList<>();
}
