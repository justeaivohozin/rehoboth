package org.icc.personservice.person;

import lombok.Getter;
import lombok.Setter;
import org.icc.personservice.contact.ContactDto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PersonDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4052036182790109000L;

    private String personFirstName;

    private String personLastName;

    private LocalDate personBirthdate;

    private Long personCampusId;

    private String personSex;

    private ContactDto contact;
}
