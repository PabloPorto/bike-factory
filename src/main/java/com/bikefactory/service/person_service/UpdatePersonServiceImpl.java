package com.bikefactory.service.person_service;

import com.bikefactory.dto.SaveOrUpdatePersonDto;
import com.bikefactory.exception.PersonNotFoundException;
import com.bikefactory.model.Person;
import com.bikefactory.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;

@Service
public class UpdatePersonServiceImpl implements UpdatePersonService{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void update(SaveOrUpdatePersonDto saveOrUpdatePersonDto, Integer id) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        person.setModifiedDate(Date.from(Instant.now()));

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(saveOrUpdatePersonDto,person);

        personRepository.save(person);
    }
}
