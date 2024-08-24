package org.icc.campusservice.country;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CountryResolver.class})
public interface CountryMapper {

    CountryResponse toResponse(Country country);

    Country toEntity(CountryDto countryDto);

    Country toEntity(Long countryId);

    List<CountryResponse> toResponse(List<Country> countryList);

    void updateCountry(CountryDto countryDto, @MappingTarget Country country);

}
