package org.icc.campusservice.region;

import lombok.Getter;
import lombok.Setter;
import org.icc.campusservice.town.TownResponse;

import java.util.Set;

@Getter
@Setter
public class RegionResponse {

    private Long regionId;

    private String regionName;

    private Set<TownResponse> towns;
}
