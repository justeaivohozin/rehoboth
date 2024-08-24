package org.icc.campusservice.region;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class RegionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 9184118964489135461L;
    private String regionName;
}
