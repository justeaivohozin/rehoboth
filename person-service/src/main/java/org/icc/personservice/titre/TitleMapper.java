package org.icc.personservice.titre;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TitleMapper {

    TitleResponse toResponse(Title title);

    Title toTitle(TitleDto titleDto);

    @Mapping(target = "titleId", ignore = true)
    void updateTitle(TitleDto titleDto, @MappingTarget Title title);
}
