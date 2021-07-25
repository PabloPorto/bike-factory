package com.bikefactory.service.person_service;

import com.bikefactory.dto.SaveOrUpdatePersonDto;

public interface UpdatePersonService {

    void update(SaveOrUpdatePersonDto saveOrUpdatePersonDto, Integer id);
}
