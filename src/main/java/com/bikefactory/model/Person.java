package com.bikefactory.model;

import com.bikefactory.enums.PersonType;
import org.springframework.data.annotation.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer businessEntityId;
    private PersonType personType;
    private Integer nameStyle;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private Integer emailPromotion;
    private String additionalContactInfo;
    private String demographics;
    private String rowGuide;
    private LocalDateTime lastModified;

    @Transient
    public void modified() {
        setLastModified(LocalDateTime.now());
    }

}
