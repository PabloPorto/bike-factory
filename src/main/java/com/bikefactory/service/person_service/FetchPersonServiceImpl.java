package com.bikefactory.service.person_service;

import com.bikefactory.exception.PersonNotFoundException;
import com.bikefactory.model.Person;
import com.bikefactory.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchPersonServiceImpl implements FetchPersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findPersonById(Integer id) {
        return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    @Override
    public Person findPersonByRowGuide(String rowGuide) {
        return personRepository.findByRowGuide(rowGuide).orElseThrow(PersonNotFoundException::new);
    }
}
