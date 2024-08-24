package org.icc.campusservice.common;

import lombok.RequiredArgsConstructor;
import org.icc.campusservice.campus.CampusService;
import org.icc.campusservice.country.CountryService;
import org.icc.campusservice.region.RegionService;
import org.icc.campusservice.town.TownService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/campus-service")
public abstract class BaseService {
    protected final CountryService countryService;
    protected final TownService townService;
    protected final CampusService campusService;
    protected final RegionService regionService;
}
