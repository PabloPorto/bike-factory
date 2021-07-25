package com.bikefactory.service.person_service;

import com.bikefactory.model.Person;

public interface FetchPersonService {

    Person findPersonById(Integer id);

    Person findPersonByRowGuide(String rowGuide);
}
