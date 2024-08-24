package org.icc.personservice.person;

import lombok.Getter;
import lombok.Setter;
import org.icc.personservice.contact.ContactResponse;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PersonResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 7951823903533691348L;
    private Long personId;

    private String personFirstName;

    private String personLastName;

    private LocalDate personBirthdate;

    private Long personCampusId;

    private String personSex;

    private ContactResponse contact;
}
