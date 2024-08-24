package org.icc.personservice.person;

import jakarta.persistence.*;
import lombok.*;
import org.icc.personservice.common.BaseEntity;
import org.icc.personservice.contact.Contact;
import org.icc.personservice.model.Campus;
import org.icc.personservice.titre.Title;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PERSON_SERVICE_PERSON", schema = "person_sch")
@SequenceGenerator(name = "PES_ID_PER", sequenceName = "PES_ID_PER", allocationSize = 1, schema = "person_sch")
public class Person extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1610376588092607285L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PES_ID_PER")
    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "PERSON_FIRST_NAME", nullable = false)
    private String personFirstName;

    @Column(name = "PERSON_LAST_NAME", nullable = false)
    private String personLastName;

    @Column(name = "PERSON_BIRTH_NAME")
    private LocalDate personBirthdate;

    @Column(name = "PERSON_CAMPUS_ID")
    private Long personCampusId;

    @Enumerated(EnumType.STRING)
    @Column(name = "PERSON_SEX")
    private SexEnum personSex;

    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

    @OneToMany(mappedBy = "person")
    private Set<Title> titles;

    @Transient
    private Campus campus;

    /*@Column(name = "PERSON_CAMPUS_ID")
    private Long campusId;*/


}
