package org.icc.campusservice.country;

import org.icc.campusservice.campus.CampusService;
import org.icc.campusservice.common.BaseService;
import org.icc.campusservice.common.PageResponse;
import org.icc.campusservice.region.RegionService;
import org.icc.campusservice.town.TownService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController extends BaseService {

    private static final String COUNTRY_PATH = "/countries";

    public CountryController(CountryService countryService, TownService townService, CampusService campusService, RegionService regionService) {
        super(countryService, townService, campusService, regionService);
    }

    @GetMapping(COUNTRY_PATH)
    public ResponseEntity<PageResponse> getCountries(@RequestParam(name = "name") String name,
                                                     @RequestParam(name = "continent") String continent,
                                                     @RequestParam(name = "page") int page,
                                                     @RequestParam(name = "size") int size) {
        return ResponseEntity.ok(countryService.getCountries(name, continent, page, size));
    }

    @PostMapping(COUNTRY_PATH + "/country")
    public ResponseEntity<CountryResponse> addCountry(@RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.saveCountry(countryDto));
    }

    @GetMapping(COUNTRY_PATH + "/country/{id}")
    public ResponseEntity<CountryResponse> getCountry(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PutMapping(COUNTRY_PATH + "/country/{id}")
    public ResponseEntity<CountryResponse> updateCountry(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.updateCountry(id, countryDto));
    }
}
