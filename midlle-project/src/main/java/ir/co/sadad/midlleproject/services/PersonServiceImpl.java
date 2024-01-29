package ir.co.sadad.midlleproject.services;

import ir.co.sadad.midlleproject.entity.PersonEntity;
import ir.co.sadad.midlleproject.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    @Override
    public PersonEntity createPerson(PersonEntity person) {
        return personRepository.save(person);
    }

    @Override
    public PersonEntity getPersonById(String personId) {
        Optional<PersonEntity> optionalUser = personRepository.findById(personId);
        return optionalUser.get();
    }

    @Override
    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public PersonEntity updatePerson(PersonEntity person) {
        PersonEntity existingPerson = personRepository.findById(person.getId()).get();
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setGender(person.getGender());
        existingPerson.setCountry(person.getCountry());
        existingPerson.setAge(person.getAge());
        PersonEntity updatedPerson = personRepository.save(existingPerson);
        return updatedPerson;
    }

    @Override
    public void deletePerson(String personId) {
        personRepository.deleteById(personId);
    }

}
