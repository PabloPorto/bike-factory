package com.bikefactory.service.person_service;

import com.bikefactory.dto.SaveOrUpdatePersonDto;
import com.bikefactory.exception.TableEmptyException;
import com.bikefactory.model.Person;
import com.bikefactory.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

@Service
public class SavePersonServiceImpl implements SavePersonService{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void insertNewPerson(SaveOrUpdatePersonDto saveOrUpdatePersonDto) {
        String rowGuide = UUID.randomUUID().toString();
        Person lastInserted = personRepository.findFirstByOrderByBusinessEntityIdDesc().orElseThrow(TableEmptyException::new);

        Person person = new Person();
        person.setBusinessEntityId(lastInserted.getBusinessEntityId() + 1);
        person.setRowGuide(rowGuide);
        person.setModifiedDate(Date.from(Instant.now()));

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(saveOrUpdatePersonDto, person);

        personRepository.save(person);
    }
}
