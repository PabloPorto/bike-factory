package com.bikefactory.dto;

import com.bikefactory.enums.PersonType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveOrUpdatePersonDto {

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
}
