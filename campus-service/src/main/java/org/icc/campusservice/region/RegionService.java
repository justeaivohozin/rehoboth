package org.icc.campusservice.region;

import org.icc.campusservice.common.PageResponse;

public interface RegionService {

    PageResponse getAllRegions(String regionName, int page, int size);

    RegionResponse getRegionById(Long id);

    RegionResponse updateRegion(Long id, RegionDto regionDto);

    RegionResponse saveRegion(RegionDto regionDto);

    void deleteRegion(Long id);

}
