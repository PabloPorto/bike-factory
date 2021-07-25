package com.bikefactory.controller;

import com.bikefactory.dto.SaveOrUpdatePersonDto;
import com.bikefactory.model.Person;
import com.bikefactory.service.person_service.DeletePersonService;
import com.bikefactory.service.person_service.FetchPersonService;
import com.bikefactory.service.person_service.SavePersonService;
import com.bikefactory.service.person_service.UpdatePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bike-factory/persons")
public class PersonController {

    @Autowired
    private SavePersonService savePersonService;

    @Autowired
    private FetchPersonService fetchPersonService;

    @Autowired
    private UpdatePersonService updatePersonService;

    @Autowired
    private DeletePersonService deletePersonService;

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> findPerson(@PathVariable("id") Integer id){
        Person person = fetchPersonService.findPersonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @GetMapping(value="/rowguide/{rowGuide}")
    public ResponseEntity<Object> findByRowGuide(@PathVariable("rowGuide") String rowGuide){
        Person person = fetchPersonService.findPersonByRowGuide(rowGuide);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @DeleteMapping(value = "/{personId}")
    public ResponseEntity<Object> deleteById(@PathVariable ("personId") Integer personId){
        deletePersonService.deleteById(personId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/rowguide/{rowGuide}")
    public ResponseEntity<Object> deleteByRowGuide(@PathVariable ("rowGuide") String rowGuide){
        deletePersonService.deleteByRowGuide(rowGuide);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveNewPerson(@RequestBody SaveOrUpdatePersonDto saveOrUpdatePersonDto){
        savePersonService.insertNewPerson(saveOrUpdatePersonDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Object> update(@PathVariable ("id") Integer id,
                                         @RequestBody SaveOrUpdatePersonDto saveOrUpdatePersonDto){
        updatePersonService.update(saveOrUpdatePersonDto,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
