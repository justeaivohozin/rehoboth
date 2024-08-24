package org.icc.campusservice.campus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.icc.campusservice.common.BaseEntity;
import org.icc.campusservice.common.CampusServiceDefinition;
import org.icc.campusservice.contact.Contact;
import org.icc.campusservice.model.Person;
import org.icc.campusservice.town.Town;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CampusServiceDefinition.SERVICE + "_CAMPUS")
public class Campus extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5616124739262279306L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAMPUS_ID")
    private Long campusId;

    @Column(name = "CAMPUS_NAME", nullable = false, unique = true)
    private String campusName;

    @ManyToOne
    @JoinColumn(name = "TOWN_ID", nullable = false)
    private Town town;

    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

    @Transient
    private Person campusResponsible;

    @Column(name = "CAMPUS_RESPONSIBLE_ID")
    private Long campusResponsibleId;

    @Column(name = "CAMPUS_TYPE")
    @Enumerated(EnumType.STRING)
    private CampusType campusType;

}
