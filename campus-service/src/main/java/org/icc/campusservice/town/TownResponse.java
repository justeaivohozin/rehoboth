package org.icc.campusservice.town;

import lombok.Getter;
import lombok.Setter;
import org.icc.campusservice.campus.CampusResponse;

import java.util.Set;

@Getter
@Setter
public class TownResponse {
    private Long townId;
    private Set<CampusResponse> campusSet;
    private String townName;
    private String countryName;
    private String regionName;
}
