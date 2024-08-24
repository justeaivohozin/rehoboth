package org.icc.campusservice.region;

import org.icc.campusservice.campus.CampusService;
import org.icc.campusservice.common.BaseService;
import org.icc.campusservice.common.PageResponse;
import org.icc.campusservice.country.CountryService;
import org.icc.campusservice.town.TownService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegionController extends BaseService {

    private static final String REGION_PATH = "/regions";

    public RegionController(CountryService countryService, TownService townService, CampusService campusService, RegionService regionService) {
        super(countryService, townService, campusService, regionService);
    }

    @GetMapping(REGION_PATH)
    public ResponseEntity<PageResponse> getAllRegions(@RequestParam(name = "regionName") String regionName,
                                                      @RequestParam(name = "page") int page,
                                                      @RequestParam(name = "size") int size) {
        return ResponseEntity.ok(regionService.getAllRegions(regionName, page, size));
    }

    @GetMapping(REGION_PATH + "/region/{id}")
    public ResponseEntity<RegionResponse> getRegionById(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.getRegionById(id));
    }

    @PostMapping(REGION_PATH + "/region")
    public ResponseEntity<RegionResponse> addNewRegion(@RequestBody RegionDto regionDto) {
        return ResponseEntity.ok(regionService.saveRegion(regionDto));
    }

    @PutMapping(REGION_PATH + "/region/{id}")
    public ResponseEntity<RegionResponse> updateRegion(@PathVariable Long id, @RequestBody RegionDto regionDto) {
        return ResponseEntity.ok(regionService.updateRegion(id, regionDto));
    }

    @DeleteMapping(REGION_PATH + "/region/{id}")
    public void deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
    }
}
