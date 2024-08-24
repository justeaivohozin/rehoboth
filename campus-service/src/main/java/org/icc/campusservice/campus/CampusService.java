package org.icc.campusservice.campus;

import org.icc.campusservice.common.PageResponse;
import org.icc.campusservice.model.Person;

import java.util.List;

public interface CampusService {

    PageResponse getAllCampus(String campusName, String townName, int page, int size);

    CampusResponse getCampusById(Long id);

    CampusResponse addCampus(CampusDto campusDto);

    CampusResponse updateCampus(Long id, CampusDto campusDto);

    void deleteCampus(Long id);

    CampusResponse addResponsibleToCampus(Long id, Person person);

    List<CampusResponse> getCampusWithName(String name);

}
