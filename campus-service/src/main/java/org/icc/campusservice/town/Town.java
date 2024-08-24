package org.icc.campusservice.town;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.icc.campusservice.campus.Campus;
import org.icc.campusservice.common.BaseEntity;
import org.icc.campusservice.country.Country;
import org.icc.campusservice.region.Region;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

/**
 * Town information
 * Town's within ICC is present
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CAMPUS_SERVICE_TOWN")
public class Town extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 222050543955123946L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOWN_ID")
    private Long townId;

    @Column(name = "TOWN_NAME", nullable = false, unique = true)
    private String townName;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "town")
    private Set<Campus> campusSet;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;
}
