package org.icc.personservice.person;

import lombok.RequiredArgsConstructor;
import org.icc.personservice.common.PageResponse;
import org.icc.personservice.common.clients.CampusRestClient;
import org.icc.personservice.common.exception.custom.ResourceNotFoundException;
import org.icc.personservice.model.Campus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final CampusRestClient campusRestClient;
    private final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Override
    public PageResponse getAllPersons(String firstName, String lastName, int page, int size) {
        LOG.info("Get all persons matching provided information first name = {} and last name = {}", firstName, lastName);
        Pageable pageable = PageRequest.of(page - 1, size);
        List<Person> persons = personRepository.findByPersonFirstNameContainsOrPersonLastNameContains(firstName, lastName, pageable);
        List<PersonResponse> personResponseList = persons.stream().map(personMapper::toResponse).toList();
        return PageResponse.builder()
                .elements(personResponseList)
                .elementCount(personRepository.countByPersonFirstNameContainsAndPersonLastNameContains(firstName, lastName))
                .build();

    }

    @Override
    public PersonResponse getPerson(Long id) {
        LOG.info("Get person with the identifier = {}", id);
        return personRepository.findById(id).map(personMapper::toResponse).orElseThrow(() -> new ResourceNotFoundException(
                "La personne que vous essayez de récupérer n'existe pas."
        ));
    }

    @Override
    public PersonResponse addPerson(PersonDto personDto) {
        LOG.info("Save new person with first name = {} and last name = {}", personDto.getPersonFirstName(), personDto.getPersonLastName());
        Person person = personMapper.toPerson(personDto);
        person = personRepository.save(person);
        return personMapper.toResponse(person);
    }


    @Override
    public PersonResponse updatePerson(Long id, PersonDto personDto) {
        LOG.info("Update person with the identifier = {}", id);
        return personRepository.findById(id).map(person -> {
            personMapper.updatePerson(personDto, person);
            person = personRepository.save(person);
            return personMapper.toResponse(person);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "La personne que vous essayez de récupérer n'existe pas."
        ));
    }

    @Override
    public void deletePerson(Long id) {
        LOG.info("Delete person with the identifier = {}", id);
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "La personne que vous essayez de supprimer n'existe pas."
        ));
        personRepository.delete(person);
    }

    /**
     * Get a campus with provided identifier
     *
     * @param id campus identifier
     * @return null or Campus
     */
    private Campus getCampus(Long id) {
        if (id == null) {
            return null;
        }
        return campusRestClient.findByCampusId(id);
    }
}
