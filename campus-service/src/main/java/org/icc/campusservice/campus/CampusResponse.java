package org.icc.campusservice.campus;

import lombok.Getter;
import lombok.Setter;
import org.icc.campusservice.contact.ContactResponse;
import org.icc.campusservice.model.Person;

@Getter
@Setter
public class CampusResponse {
    private Long campusId;
    private String campusName;
    private String townName;
    private ContactResponse contact;
    private Person campusResponsible;
    private String campusType;
}
