package org.icc.campusservice.town;

import org.icc.campusservice.country.CountryMapper;
import org.icc.campusservice.region.RegionMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {CountryMapper.class, RegionMapper.class, TownResolver.class})
public interface TownMapper {

    Town toTown(TownDto townDto);

    @Mapping(target = "countryName", source = "country.countryName")
    @Mapping(target = "regionName", source = "region.regionName")
    TownResponse toResponse(Town town);

    Set<TownResponse> toResponse(Set<Town> town);

    List<TownResponse> toResponse(List<Town> town);

    Town toTown(Long id);

    @Mapping(target = "townId", ignore = true)
    void updateTown(TownDto townDto, @MappingTarget Town town);


}
