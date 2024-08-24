package org.icc.campusservice.town;

import org.icc.campusservice.campus.CampusService;
import org.icc.campusservice.common.BaseService;
import org.icc.campusservice.common.PageResponse;
import org.icc.campusservice.country.CountryService;
import org.icc.campusservice.region.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TownController extends BaseService {

    private static final String TOWN_PATH = "/towns";

    public TownController(CountryService countryService, TownService townService, CampusService campusService, RegionService regionService) {
        super(countryService, townService, campusService, regionService);
    }

    @PostMapping(TOWN_PATH + "/town")
    public ResponseEntity<TownResponse> addNewTown(@RequestBody TownDto townDto) {
        return ResponseEntity.ok(townService.saveTown(townDto));
    }

    @GetMapping(TOWN_PATH + "/town/{id}")
    public ResponseEntity<TownResponse> getTown(@PathVariable Long id) {
        return ResponseEntity.ok(townService.getByTownById(id));
    }

    @PutMapping(TOWN_PATH + "/town/{id}")
    public ResponseEntity<TownResponse> updateTown(@PathVariable Long id, @RequestBody TownDto townDto) {
        return ResponseEntity.ok(townService.updateTown(id, townDto));
    }

    @DeleteMapping(TOWN_PATH + "/town/{id}")
    public void deleteTown(@PathVariable Long id) {
        townService.deleteTown(id);
    }

    @GetMapping(TOWN_PATH)
    public ResponseEntity<PageResponse> getAllTown(@RequestParam(name = "townName") String townName,
                                                   @RequestParam(name = "countryName") String countryName,
                                                   @RequestParam(name = "page") int page,
                                                   @RequestParam(name = "size") int size) {
        return ResponseEntity.ok(townService.getTowns(townName, countryName, page, size));
    }

}
