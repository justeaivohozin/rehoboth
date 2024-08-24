package org.icc.campusservice.common.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.icc.campusservice.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "PERSON-SERVICE")
public interface PersonRestClient {

    @GetMapping("/person-service/persons/person/{id}")
    @CircuitBreaker(name = "personService", fallbackMethod = "getDefaultPerson")
    Person findPersonById(@PathVariable(name = "id") Long id);

    @GetMapping("/person-service/persons")
    @CircuitBreaker(name = "personService", fallbackMethod = "getAllPersons")
    List<Person> getAllCustomers();

    default Person getDefaultPerson(Long id, Exception exception) {
        Person person = new Person();
        person.setPersonId(id);
        person.setPersonFirstName("Not Found");
        person.setPersonLastName("Not Found");
        return person;
    }

    default List<Person> getAllPersons(Exception exception) {
        return Collections.emptyList();
    }

}
