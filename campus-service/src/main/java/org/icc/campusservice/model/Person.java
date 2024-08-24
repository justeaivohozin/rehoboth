package org.icc.campusservice.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 9087460493890979261L;

    private Long personId;

    private String personFirstName;

    private String personLastName;

    private Long personCampusId;

}
