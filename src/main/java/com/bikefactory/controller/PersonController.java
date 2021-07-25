package com.bikefactory.controller;

import com.bikefactory.dto.SaveOrUpdatePersonDto;
import com.bikefactory.model.Person;
import com.bikefactory.service.person_service.DeletePersonService;
import com.bikefactory.service.person_service.FetchPersonService;
import com.bikefactory.service.person_service.SavePersonService;
import com.bikefactory.service.person_service.UpdatePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    private FetchPersonService fetchPersonService;

    @Autowired
    private DeletePersonService deletePersonService;

    @Autowired
    private UpdatePersonService updatePersonService;

    @Autowired
    private SavePersonService savePersonService;

    @GetMapping(value="/search-id/{id}")
    public ResponseEntity<Object> findPerson(@PathVariable("id") Integer id){
        Person person = fetchPersonService.findPersonById(id);
        return ResponseEntity.ok().headers(new HttpHeaders()).body(person);
    }

    @GetMapping(value="/search-row-guide/{rowGuide}")
    public ResponseEntity<Object> findByRowGuide(@PathVariable("rowGuide") String rowGuide){
        Person person = fetchPersonService.findPersonByRowGuide(rowGuide);
        return ResponseEntity.ok().headers(new HttpHeaders()).body(person);
    }

    @DeleteMapping(value = "/delete-by-id/{personId}")
    public ResponseEntity<Object> deleteById(@PathVariable ("personId") Integer personId){
        deletePersonService.deleteById(personId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-rowguide/{rowGuide}")
    public ResponseEntity<Object> deleteByRowGuide(@PathVariable ("rowGuide") String rowGuide){
        deletePersonService.deleteByRowGuide(rowGuide);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveNewPerson(@RequestBody SaveOrUpdatePersonDto saveOrUpdatePersonDto){
        savePersonService.insertNewPerson(saveOrUpdatePersonDto);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<Object> update(@PathVariable ("id") Integer id,
                                         @RequestBody SaveOrUpdatePersonDto saveOrUpdatePersonDto){
        updatePersonService.update(saveOrUpdatePersonDto,id);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

}
