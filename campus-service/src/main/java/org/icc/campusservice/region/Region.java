package org.icc.campusservice.region;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.icc.campusservice.common.BaseEntity;
import org.icc.campusservice.common.CampusServiceDefinition;
import org.icc.campusservice.town.Town;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

/**
 * Region information
 * Contains group of town managed by specific person
 * Could be equal to country department
 */
@Entity
@Table(name = CampusServiceDefinition.SERVICE + "_REGION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1555412098403734202L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private Long regionId;

    @Column(name = "REGION_NAME", nullable = false, unique = true)
    @NotNull
    @NotBlank
    private String regionName;

    @OneToMany(mappedBy = "region")
    private Set<Town> towns;
}
