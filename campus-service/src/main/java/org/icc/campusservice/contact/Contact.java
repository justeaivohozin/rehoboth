package org.icc.campusservice.contact;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.icc.campusservice.campus.Campus;
import org.icc.campusservice.common.CampusServiceDefinition;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = CampusServiceDefinition.SERVICE + "_CONTACT")
public class Contact implements Serializable {

    @Serial
    private static final long serialVersionUID = -2632792199255704679L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Campus campus;

}
