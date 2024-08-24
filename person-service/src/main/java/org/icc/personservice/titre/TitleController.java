package org.icc.personservice.titre;

import org.icc.personservice.common.BaseService;
import org.icc.personservice.common.PageResponse;
import org.icc.personservice.person.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TitleController extends BaseService {

    private static final String TITLE_PATH = "/titles";

    public TitleController(PersonService personService, TitleService titleService) {
        super(personService, titleService);
    }

    @GetMapping(TITLE_PATH)
    public ResponseEntity<PageResponse> getAllTitles(@RequestParam(name = "titleName") String titleName,
                                                     @RequestParam(name = "page") int page,
                                                     @RequestParam(name = "size") int size) {
        return ResponseEntity.ok(titleService.getTitles(titleName, page, size));
    }

    @GetMapping(TITLE_PATH + "/title/{id}")
    public ResponseEntity<TitleResponse> getTitle(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(titleService.getTitle(id));
    }

    @PostMapping(TITLE_PATH + "/title")
    public ResponseEntity<TitleResponse> addNewTitle(@RequestBody TitleDto titleDto) {
        return ResponseEntity.ok(titleService.addNewTitle(titleDto));
    }

    @PutMapping(TITLE_PATH + "/title/{id}")
    public ResponseEntity<TitleResponse> updateTitle(@PathVariable(name = "id") Long id,
                                                     @RequestBody TitleDto titleDto) {
        return ResponseEntity.ok(titleService.updateTitle(id, titleDto));
    }

    @DeleteMapping(TITLE_PATH + "/title/{id}")
    public void deleteTitle(@PathVariable(name = "id") Long id) {
        titleService.deleteTitle(id);
    }

}
