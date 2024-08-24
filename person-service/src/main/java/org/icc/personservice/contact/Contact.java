package org.icc.personservice.contact;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.icc.personservice.person.Person;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PERSON_SERVICE_CONTACT", schema = "person_sch")
@SequenceGenerator(name = "PES_ID_CON", sequenceName = "PES_ID_CON", allocationSize = 1, schema = "person_sch")
public class Contact implements Serializable {

    @Serial
    private static final long serialVersionUID = -3459709740124045260L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PES_ID_CON")
    @Column(name = "CONTACT_ID")
    private Long contactId;

    @Column(name = "CONTACT_EMAIL", nullable = false)
    private String email;

    @Column(name = "CONTACT_PHONE_NUMBER")
    private String contactPhoneNumber;

    @Embedded
    private Address address;

    @Embedded
    private SocialMedia socialMedia;

    @OneToOne(mappedBy = "contact")
    private Person person;

}
