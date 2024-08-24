package org.icc.campusservice.town;

import org.icc.campusservice.common.PageResponse;

/**
 * Town operation management class
 */
public interface TownService {

    PageResponse getTowns(String townName, String countryName, int page, int size);

    TownResponse getTownByName(String townName);

    TownResponse getByTownById(Long id);

    TownResponse saveTown(TownDto town);

    void deleteTown(Long id);

    TownResponse updateTown(Long id, TownDto townDto);

}
