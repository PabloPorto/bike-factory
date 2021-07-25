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
@Entity(name = "customer")
public class Customer  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "personid")
    private Integer personId;

    @Column(name = "storeid")
    private Integer storeId;

    @Column(name = "territoryid")
    private Integer territoryId;

    @Column(name = "accountnumber")
    private String accountNumber;

    @Column(name = "rowguide")
    private String rowGuide;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    @ManyToOne
    private Person person;

    @OneToMany
    private List<SalesOrderHeader> salesOrderHeaders = new ArrayList<>();

    public Customer(Integer personId, Integer storeId, Integer territoryId, String accountNumber) {
        this.personId = personId;
        this.storeId = storeId;
        this.territoryId = territoryId;
        this.accountNumber = accountNumber;
    }
}
