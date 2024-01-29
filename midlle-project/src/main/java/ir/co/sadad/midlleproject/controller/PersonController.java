package ir.co.sadad.midlleproject.controller;

import ir.co.sadad.midlleproject.entity.PersonEntity;
import ir.co.sadad.midlleproject.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/persons")
public class PersonController {
    private PersonService personService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonEntity> createPerson(@RequestBody PersonEntity person) {
        PersonEntity savedPerson = personService.createPerson(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

//    // http://localhost:8080/api/persons/1
    @GetMapping("{id}")
    public ResponseEntity<PersonEntity> getPersonById(@PathVariable("id") String personId) {
        PersonEntity person = personService.getPersonById(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonEntity>> getAllUsers() {
        List<PersonEntity> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonEntity> updatePerson(@PathVariable("id") String personId,
                                                 @RequestBody PersonEntity person) {
        person.setId(personId);
        PersonEntity updatedPerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String personId) {
        personService.deletePerson(personId);
        return new ResponseEntity<>("PERSON successfully deleted!", HttpStatus.OK);
    }
}
