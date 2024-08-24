package org.icc.campusservice.town;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class TownDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -7799268124700143520L;
    private String townName;
    private Long country;
    private Long region;
}
