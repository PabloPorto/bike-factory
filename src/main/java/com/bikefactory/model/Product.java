package com.bikefactory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer productId;
    private String name;
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
    private Date sellStartDate;
    private Date sellEndDate;
    private Date discontinuedDate;
    private String rowGuide;
    private LocalDateTime lastModified;

    @Transient
    public void modified() {
        setLastModified(LocalDateTime.now());
    }

}
