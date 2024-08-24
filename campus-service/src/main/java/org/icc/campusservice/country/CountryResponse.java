package org.icc.campusservice.country;

import lombok.Getter;
import lombok.Setter;
import org.icc.campusservice.town.TownResponse;

import java.util.Set;

@Getter
@Setter
public class CountryResponse {
    private String countryAcronym;
    private String countryName;
    private Set<TownResponse> towns;
    private String continent;
}
