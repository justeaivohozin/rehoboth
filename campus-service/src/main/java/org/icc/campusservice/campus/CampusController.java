package org.icc.campusservice.campus;

import org.icc.campusservice.common.BaseService;
import org.icc.campusservice.common.PageResponse;
import org.icc.campusservice.country.CountryService;
import org.icc.campusservice.model.Person;
import org.icc.campusservice.region.RegionService;
import org.icc.campusservice.town.TownService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampusController extends BaseService {
    private static final String CAMPUS_PATH = "/campuses";

    public CampusController(CountryService countryService, TownService townService, CampusService campusService, RegionService regionService) {
        super(countryService, townService, campusService, regionService);
    }

    @GetMapping(CAMPUS_PATH)
    public ResponseEntity<PageResponse> getCampuses(@RequestParam(name = "campusName") String campusName,
                                                    @RequestParam(name = "townName") String townName,
                                                    @RequestParam(name = "page") int page,
                                                    @RequestParam(name = "size") int size) {
        return ResponseEntity.ok(campusService.getAllCampus(campusName, townName, page, size));
    }

    @GetMapping(CAMPUS_PATH + "/campus/with-name")
    public ResponseEntity<List<CampusResponse>> getCampusesByName(@RequestParam(name = "campusName") String campusName) {
        return ResponseEntity.ok(campusService.getCampusWithName(campusName));
    }

    @GetMapping(CAMPUS_PATH + "/campus/{id}")
    public ResponseEntity<CampusResponse> getCampus(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(campusService.getCampusById(id));
    }

    @PutMapping(CAMPUS_PATH + "/campus/{id}")
    public ResponseEntity<CampusResponse> updateCampus(@PathVariable(name = "id") Long id, @RequestBody CampusDto campusDto) {
        return ResponseEntity.ok(campusService.updateCampus(id, campusDto));
    }

    @PostMapping(CAMPUS_PATH + "/campus")
    public ResponseEntity<CampusResponse> addNewCampus(@RequestBody CampusDto campusDto) {
        return ResponseEntity.ok(campusService.addCampus(campusDto));
    }

    @DeleteMapping(CAMPUS_PATH + "/campus/{id}")
    public void deleteCampus(@PathVariable(name = "id") Long id) {
        campusService.deleteCampus(id);
    }

    @PostMapping(CAMPUS_PATH + "/campus/{id}/add-responsible")
    public ResponseEntity<CampusResponse> addResponsibleToCampus(@PathVariable(name = "id") Long id, @RequestBody Person person) {
        return ResponseEntity.ok(campusService.addResponsibleToCampus(id, person));
    }

}
