package com.bikefactory.repository;

import com.bikefactory.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByRowGuide(String rowGuide);

    Optional<Person> findFirstByOrderByBusinessEntityIdDesc();

}
