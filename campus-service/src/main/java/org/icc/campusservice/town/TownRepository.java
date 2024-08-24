package org.icc.campusservice.town;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    /**
     * Get all town matching giving predicate
     *
     * @param townName town name
     * @param country  country name
     * @param pageable requested page
     * @return list of town
     */
    List<Town> findByTownNameContainsAndCountry_CountryNameContains(String townName, String country, Pageable pageable);

    /**
     * Get a town by name
     *
     * @param name town name
     * @return a town
     */
    Optional<Town> findByTownName(String name);


    Long countByTownNameContainsAndCountry_CountryNameContains(String townName, String country);
}
