package org.icc.campusservice.campus;

import org.icc.campusservice.contact.ContactMapper;
import org.icc.campusservice.town.TownMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {TownMapper.class, ContactMapper.class})
public interface CampusMapper {

    @Mapping(source = "campus.town.townName", target = "townName")
    CampusResponse toResponse(Campus campus);

    @Mapping(source = "townId", target = "town")
    Campus toEntity(CampusDto dto);

    void updateCampus(CampusDto campusDto, @MappingTarget Campus campus);
}
