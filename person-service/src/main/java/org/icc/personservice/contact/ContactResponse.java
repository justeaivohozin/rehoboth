package org.icc.personservice.contact;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ContactResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 4910911070243885990L;
    private Long contactId;

    private String email;

    private String contactPhoneNumber;

    private String road;

    private Integer number;

    private String town;

    private String zipCode;

    private String facebook;

    private String instagram;

    private String linkedIn;

    private String snapChat;

    private String campusName;
}
