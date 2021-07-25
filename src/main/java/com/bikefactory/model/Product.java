package com.bikefactory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Integer productId;
    private String name;

    @Column(name = "productnumber")
    private String productNumber;

    @Column(name = "makeflag")
    private Integer makeFlag;

    @Column(name = "finishedgoodsflag")
    private Integer finishedGoodsFlag;
    private String color;

    @Column(name = "safetystocklevel")
    private Integer safetyStockLevel;

    @Column(name = "reorderpoint")
    private Integer reorderPoint;

    @Column(name = "standardcost")
    private Double standardCost;

    @Column(name = "listprice")
    private Double listPrice;

    private String size;

    @Column(name = "sizeunitmeasurecode")
    private String sizeUnitMeasureCode;

    @Column(name = "weightunitmeasurecode")
    private String weightUnitMeasureCode;

    private Double weight;

    @Column(name = "daystomanufacture")
    private Integer daysToManufacture;

    @Column(name = "productline")
    private String productLine;

    @Column(name = "class")
    private String classe;

    private String style;

    @Column(name = "productsubcategoryid")
    private Integer productSubcategoryId;

    @Column(name = "productmodelid")
    private Integer productModelId;

    @Column(name = "sellstartdate")
    private Date sellStartDate;

    @Column(name = "sellenddate")
    private Date sellEndDate;

    @Column(name = "discontinueddate")
    private Date discontinuedDate;

    @Column(name = "rowguide")
    private String rowGuide;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    @OneToMany
    private List<SpecialOfferProduct> specialOfferProducts = new ArrayList<>();

    @OneToMany
    private List<SalesOrderDetail> salesOrderDetails = new ArrayList<>();

}
