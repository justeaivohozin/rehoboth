package org.icc.campusservice.contact;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactResponse {

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
