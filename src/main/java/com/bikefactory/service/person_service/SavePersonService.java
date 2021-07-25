package com.bikefactory.service.person_service;

import com.bikefactory.dto.SaveOrUpdatePersonDto;

@FunctionalInterface
public interface SavePersonService {

    void insertNewPerson(SaveOrUpdatePersonDto saveOrUpdatePersonDto);
}
