package ir.co.sadad.midlleproject.services;

import ir.co.sadad.midlleproject.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    PersonEntity createPerson(PersonEntity person);

    PersonEntity getPersonById(String personId);

    List<PersonEntity> getAllPersons();

    PersonEntity updatePerson(PersonEntity person);

    void deletePerson(String personId);
}
