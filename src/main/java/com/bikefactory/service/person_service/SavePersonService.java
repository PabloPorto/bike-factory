package com.bikefactory.service.person_service;

import com.bikefactory.dto.SaveOrUpdatePersonDto;

public interface SavePersonService {

    void insertNewPerson(SaveOrUpdatePersonDto saveOrUpdatePersonDto);
}
