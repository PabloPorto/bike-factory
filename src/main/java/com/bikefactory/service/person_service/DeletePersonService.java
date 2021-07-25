package com.bikefactory.service.person_service;

public interface DeletePersonService {

    void deleteById(Integer id);

    void deleteByRowGuide(String rowGuide);
}
