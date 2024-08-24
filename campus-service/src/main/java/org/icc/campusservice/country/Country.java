package org.icc.campusservice.country;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.icc.campusservice.common.BaseEntity;
import org.icc.campusservice.town.Town;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

/**
 * Country information
 * Country within ICC is present
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CAMPUS_SERVICE_COUNTRY")
public class Country extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1315766601523792617L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID")
    private Long countryId;

    @Column(name = "COUNTRY_NAME", nullable = false, unique = true)
    @NotNull
    @NotBlank
    private String countryName;

    @NotNull
    @NotBlank
    @Column(name = "COUNTRY_ACRONYM", nullable = false)
    private String countryAcronym;

    @NotNull
    @Column(name = "COUNTRY_CONTINENT", nullable = false)
    @Enumerated(EnumType.STRING)
    private Continent continent;

    @OneToMany(mappedBy = "country")
    private Set<Town> towns;
}
