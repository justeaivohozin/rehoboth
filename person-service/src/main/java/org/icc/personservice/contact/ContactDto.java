package org.icc.personservice.contact;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ContactDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -7945085038219202554L;
    private String email;
    private String contactPhoneNumber;
    private String road;
    private Integer number;
    private Long personId;
    private String zipCode;
    private String facebook;
    private String instagram;
    private String linkedIn;
    private String snapChat;

}
