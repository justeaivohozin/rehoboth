package org.icc.personservice.titre;

import jakarta.persistence.*;
import lombok.*;
import org.icc.personservice.common.BaseEntity;
import org.icc.personservice.person.Person;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PERSON_SERVICE_TITLE", schema = "person_sch")
@SequenceGenerator(name = "PES_ID_TL", sequenceName = "PES_ID_TL", allocationSize = 1, schema = "person_sch")
public class Title extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 3511947011078413086L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PES_ID_TL")
    @Column(name = "TITLE_ID")
    private Long titleId;

    @Column(name = "TITLE_NAME")
    private String titleName;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;
}
