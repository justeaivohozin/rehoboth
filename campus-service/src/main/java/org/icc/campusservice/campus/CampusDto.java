package org.icc.campusservice.campus;

import lombok.Getter;
import lombok.Setter;
import org.icc.campusservice.contact.ContactDto;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CampusDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 144960083365499583L;
    private String campusName;
    private Long townId;
    private String townName;
    private String campusType;
    private ContactDto contact;
    private Long campusResponsibleId;
}
