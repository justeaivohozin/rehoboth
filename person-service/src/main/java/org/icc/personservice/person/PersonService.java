package org.icc.personservice.person;

import org.icc.personservice.common.PageResponse;

public interface PersonService {

    PageResponse getAllPersons(String firstName, String lastName, int page, int size);

    PersonResponse getPerson(Long id);

    PersonResponse addPerson(PersonDto personDto);

    PersonResponse updatePerson(Long id, PersonDto personDto);

    void deletePerson(Long id);
}
