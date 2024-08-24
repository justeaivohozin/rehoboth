package org.icc.campusservice.region;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {RegionResolver.class})
public interface RegionMapper {

    RegionResponse toResponse(Region region);

    Region toRegion(RegionDto regionDto);

    Region toRegion(Long id);

    void updateRegion(RegionDto regionDto, @MappingTarget Region region);
}
