package org.icc.campusservice.country;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class CountryDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1499364652854653368L;
    private String countryAcronym;
    private String countryName;
    private String continent;
}
