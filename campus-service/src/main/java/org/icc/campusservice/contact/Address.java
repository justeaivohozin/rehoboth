package org.icc.campusservice.contact;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

    @Column(name = "ADDRESS_ROAD")
    private String road;

    @Column(name = "ADDRESS_NUMBER")
    private Integer number;

    @Column(name = "ADDRESS_TOWN")
    private String town;

    @Column(name = "ADDRESS_ZIPCODE")
    private String zipCode;
}
