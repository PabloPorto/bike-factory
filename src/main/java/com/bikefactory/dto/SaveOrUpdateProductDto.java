package com.bikefactory.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SaveOrUpdateProductDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String productNumber;
    private Integer makeFlag;
    private Integer finishedGoodsFlag;
    private String color;
    private Integer safetyStockLevel;
    private Integer reorderPoint;
    private Double standardCost;
    private Double listPrice;
    private String size;
    private String sizeUnitMeasureCode;
    private String weightUnitMeasureCode;
    private Double weight;
    private Integer daysToManufacture;
    private String productLine;
    private String classe;
    private String style;
    private Integer productSubcategoryId;
    private Integer productModelId;
    private String sellStartDate;
    private String sellEndDate;
    private String discontinuedDate;

}
