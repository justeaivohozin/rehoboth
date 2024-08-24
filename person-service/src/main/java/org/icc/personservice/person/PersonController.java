package org.icc.personservice.person;

import org.icc.personservice.common.BaseService;
import org.icc.personservice.common.PageResponse;
import org.icc.personservice.titre.TitleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController extends BaseService {

    private static final String PERSON_PATH = "/persons";

    public PersonController(PersonService personService, TitleService titleService) {
        super(personService, titleService);
    }

    @GetMapping(PERSON_PATH)
    public ResponseEntity<PageResponse> getAllPersons(@RequestParam(name = "firstName") String firstName,
                                                      @RequestParam(name = "lastName") String lastName,
                                                      @RequestParam(name = "page") int page,
                                                      @RequestParam(name = "size") int size) {
        return ResponseEntity.ok(personService.getAllPersons(firstName, lastName, page, size));
    }

    @GetMapping(PERSON_PATH + "/person/{id}")
    public ResponseEntity<PersonResponse> getPerson(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(personService.getPerson(id));
    }

    @PostMapping(PERSON_PATH + "/person")
    public ResponseEntity<PersonResponse> addNewPerson(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.addPerson(personDto));
    }

    @PutMapping(PERSON_PATH + "/person/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable(name = "id") Long id,
                                                       @RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.updatePerson(id, personDto));
    }

    @DeleteMapping(PERSON_PATH + "/person/{id}")
    public void deletePerson(@PathVariable(name = "id") Long id) {
        personService.deletePerson(id);
    }

}
