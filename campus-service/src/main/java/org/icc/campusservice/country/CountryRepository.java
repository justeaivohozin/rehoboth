package org.icc.campusservice.country;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Database layer access for country objects
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    /**
     * Get all countries matching required condition
     * Should pass predicate and page
     *
     * @param name      country name
     * @param continent country continent
     * @param pageable  page requested
     * @return a list of country
     */
    List<Country> findByCountryNameContainsOrContinent(String name, Continent continent, Pageable pageable);

    List<Country> findByCountryNameContains(String name, Pageable pageable);

    /**
     * Get a country with the provided name
     *
     * @param name country provided name
     * @return an Optional<Country>
     */
    Optional<Country> findByCountryName(String name);


    Long countByCountryNameContainsAndContinent(String name, Continent continent);

    Long countByCountryNameContains(String name);


}
