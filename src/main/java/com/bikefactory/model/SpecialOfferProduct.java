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
@Entity(name = "specialofferproduct")
public class SpecialOfferProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "specialofferid")
    private Integer specialOfferId;

    @Column(name = "productid")
    private Integer productId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rowguide")
    private String rowGuide;

    @Column(name = "modifieddate")
    private Date modifiedDate;

}
