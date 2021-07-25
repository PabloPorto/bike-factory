package com.bikefactory.service.person_service;

import com.bikefactory.exception.PersonNotFoundException;
import com.bikefactory.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonServiceImpl implements DeletePersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void deleteById(Integer id) {
        personRepository.delete(personRepository.findById(id).orElseThrow(PersonNotFoundException::new));
    }

    @Override
    public void deleteByRowGuide(String rowGuide) {
        personRepository.delete(personRepository.findByRowGuide(rowGuide).orElseThrow(PersonNotFoundException::new));
    }
}
