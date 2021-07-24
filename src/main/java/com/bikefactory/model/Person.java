package com.bikefactory.model;

import com.bikefactory.enums.PersonType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer businessEntityId;

    @Column(name = "persontype")
    private PersonType personType;

    @Column(name = "namestyle")
    private Integer nameStyle;

    private String title;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    private String suffix;

    @Column(name = "emailpromotion")
    private Integer emailPromotion;

    @Column(name = "additionalcontact")
    private String additionalContactInfo;

    private String demographics;

    @Column(name = "rowguide")
    private String rowGuide;

    @Column(name = "modifieddate")
    private Date modifiedDate;

}
