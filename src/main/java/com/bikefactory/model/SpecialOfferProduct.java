package com.bikefactory.model;

import com.bikefactory.util.SpecialOfferProductRelationshipId;
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
@Entity(name = "specialofferproduct")
@IdClass(SpecialOfferProductRelationshipId.class)
public class SpecialOfferProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "specialofferid")
    private Integer specialOfferId;

    @Id
    @Column(name = "productid")
    private Integer productId;

    @Column(name = "rowguide", unique = true)
    private String rowGuide;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    @OneToMany
    private List<SalesOrderDetail> salesOrderDetails = new ArrayList<>();

    @ManyToOne
    private Product product;

}
